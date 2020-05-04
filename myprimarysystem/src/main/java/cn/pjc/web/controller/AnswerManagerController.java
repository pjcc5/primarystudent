package cn.pjc.web.controller;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.pjc.dto.QuestionResultDto;
import cn.pjc.dto.ResultMessage;
import cn.pjc.pojo.Acount;
import cn.pjc.pojo.Answer;
import cn.pjc.pojo.Answerquestion;
import cn.pjc.pojo.Exam;
import cn.pjc.pojo.Examdetail;
import cn.pjc.pojo.Question;
import cn.pjc.service.AnswerQuestionService;
import cn.pjc.service.AnswerService;
import cn.pjc.service.ExamService;
import cn.pjc.service.ExamdetailService;
import cn.pjc.service.QuestionService;
import cn.pjc.util.CustomTimestampEditor;
import cn.pjc.util.IDHelper;

@Controller
@RequestMapping("/answer")
public class AnswerManagerController {
//	@InitBinder    
//	public void initBinder(WebDataBinder binder) {
//	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");    
//	        dateFormat.setLenient(false);    
//	        binder.registerCustomEditor(Timestamp.class, new CustomTimestampEditor(dateFormat, true));    
//	}
	@Autowired
	private AnswerService as =null;
	@Autowired
	private AnswerQuestionService aqs = null;
	@Autowired
	private QuestionService qs= null;
	@Autowired
	private ExamService es = null;
	@Autowired
	private ExamdetailService eds = null;
	@ResponseBody
	@RequestMapping("/saveanswer")
	public ResultMessage saveanswer(Answer answer)
	{
		ResultMessage rm = new ResultMessage("失败", -1, false);
		System.out.println(answer);
		answer.setAnid(IDHelper.getUUID());
		answer.setAnnumber(IDHelper.getUUID());
		answer.setAnscore(-1);
		//保存answer
		boolean result = this.as.saveAnswer(answer);
		if(result)
		{   
			rm.setMessage(answer.getAnnumber());
			rm.setFlag(true);
		}
		return rm;
	}
	
	@ResponseBody
	@RequestMapping("/saveanswerquestion.do")
	public ResultMessage saveanswerquestion(Answerquestion aq)
	{
		ResultMessage rm = new ResultMessage("交卷成功", -1, false);
		aq.setAqid(IDHelper.getUUID());
		boolean result = this.aqs.saveAnswerQuestion(aq);
		if(result)
		{
			rm.setFlag(true);
			rm.setMessage("交卷成功");
		}
		else{
			rm.setFlag(false);
			rm.setMessage("交卷失败");
		}
		
		

		return rm;
	}
	
	
	@RequestMapping("/showmyexamresut.do")
	public ModelAndView showmyexamresut(HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		Acount acount =(Acount)session.getAttribute("acount");
		if(acount == null || "".equals(acount.getAid()) || acount.getAname()==null ||"".equals(acount.getAname()) )
		{
			mav.setViewName("forward:/");
			return mav;
		}
		
		String aname = acount.getAname();
		List<Answer> list = this.as.queryAnswerByAnname(aname);
		session.setAttribute("answers", list);
		mav.setViewName("redirect:/needlogin/examresult.jsp");
		
		
		return mav;
	}
	
	//算分方法
		 @ResponseBody
		 @RequestMapping("/calcscore.do")
		 public  ResultMessage calcscore(String annumber) throws Exception
		 {
			 System.out.println("annumber:"+annumber);
			 ResultMessage rm = new ResultMessage("ok", -1, false);
			 //查出answer
			 Answer answer= this.as.queryAnswerByAnnumber(annumber);
			 int count = 0;
			 System.out.println("执行了算分");
			 while(answer == null)
			 {		
				 Thread.sleep(1000);
				 answer= this.as.queryAnswerByAnnumber(annumber);
				 count++;
				 if(count >20)
				 {
					 //20秒钟之后还是没有查询到就返回失败
					 rm.setFlag(false);
					 rm.setMessage("改卷超时,请刷新重试");
					 return rm;
				 }
			 }
			 //根据answer查出answerquestion
			 count =0;
			 List<Answerquestion> list = this.aqs.queryAnswerquestionByAqnumber(answer.getAnnumber());
			 while(list == null || list.size() == 0)
			 {		
				 Thread.sleep(1000);
				 list= this.aqs.queryAnswerquestionByAqnumber(answer.getAnnumber());
				 count++;
				 if(count >20)
				 {
					 //20秒钟之后还是没有查询到就返回失败
					 rm.setFlag(false);
					 rm.setMessage("改卷超时,请刷新重试");
					 return rm;
				 }
			 }
			
			 System.out.println(list.size()+"答案数");
			 List<QuestionResultDto> qrds = new ArrayList<QuestionResultDto>();
			 int rightnum = 0;
			 //计算分数
			 for (int i = 0; i < list.size(); i++) {
				 {
					 Question question = this.qs.queryQuestionByQid(list.get(i).getAqquestionid());
					 if(question.getQrightanswer().equals(list.get(i).getAqanswer()))
					 {
//						 qrds.add(new QuestionResultDto(question,true));
						 rightnum++;
					 }else{
//						 qrds.add(new QuestionResultDto(question));
					 }
				 }
				 
//				 System.out.println("对的题数:"+rightnum);
//				 for (QuestionResultDto questionResultDto : qrds) {
//					System.out.println(questionResultDto.getQcontent()+questionResultDto.getIsright());
//				}
			}
			 double score1 = new BigDecimal((float)rightnum/list.size()).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();//分数
			 int score2 = new Double(score1*100).intValue();
			 //保存score 
			 answer.setAnscore(score2);
			 boolean result =  this.as.modifyAnswer(answer);
			 if(result)
			 {	
				 rm.setFlag(true);
				 rm.setMessage("保存成功,分数为:"+score2);
			 }
			
			 return rm;
		 }
		 
		 
		 /*
		  * 展示答题详情
		  */
		 @RequestMapping("showexamresultdetail.do")
		 public ModelAndView showexamresultdetail(String aqnumber,HttpSession session) throws InterruptedException
		 {
			 ModelAndView mav = new ModelAndView();
			 if(aqnumber == null || "".equals(aqnumber.trim()))
			 {
				 mav.setViewName("redirect:/");
				 return mav;
			 }
			 
			 
			 Answer answer= this.as.queryAnswerByAnnumber(aqnumber);
			 Exam e = this.es.queryExamByExdnumber(answer.getAnexamnumber());
			 Examdetail ed = this.eds.queryExamdetailByExdnumber(e.getExnumber()).get(0);
			 int count = 0;
			 while(answer == null)
			 {		
				 Thread.sleep(1000);
				 answer= this.as.queryAnswerByAnnumber(aqnumber);
				 count++;
				 if(count >5)
				 {
					 //5秒钟之后还是没有查询到就返回主页
					 mav.setViewName("redirect:/");
					 return mav;
				 }
			 }
			 //根据answer查出answerquestion
			 count =0;
			 
			 
			 
			 List<Answerquestion> list = this.aqs.queryAnswerquestionByAqnumber(answer.getAnnumber());
			 while(list == null || list.size() == 0)
			 {		
				 Thread.sleep(1000);
				 list= this.aqs.queryAnswerquestionByAqnumber(answer.getAnnumber());
				 count++;
				 if(count >5)
				 {
					 //5秒钟之后还是没有查询到就返回主页
					 mav.setViewName("redirect:/");
					 return mav;
				 }
			 }
			
			 System.out.println(list.size()+"答案数");
			 List<QuestionResultDto> qrds = new ArrayList<QuestionResultDto>();
			
			 int rightnum = 0;
			 //计算分数
			 for (int i = 0; i < list.size(); i++) {
				 {
					 Question question = this.qs.queryQuestionByQid(list.get(i).getAqquestionid());
					 //查询出每一题用户的答案
					 Map<String,Object> map = new HashMap<>();
					 map.put("aqnumber", answer.getAnnumber());
					 map.put("aqquestionid", question.getQid());
					 Answerquestion useranswer = this.aqs.queryAnswerquestionByAqnumberAndAqquestionid(map);
					 if(question.getQrightanswer().equals(list.get(i).getAqanswer()))
					 {
						 qrds.add(new QuestionResultDto(question,true,useranswer.getAqanswer()));
						 rightnum++;
					 }else{
						 qrds.add(new QuestionResultDto(question,false,useranswer.getAqanswer()));
					 }
				 }
				 
				 System.out.println("对的题数:"+rightnum);
				 for (QuestionResultDto questionResultDto : qrds) {
					System.out.println(questionResultDto.getQcontent()+questionResultDto.getIsright()+"用户答案:"+questionResultDto.getUseranswer());
				}
			}
//			 session.setAttribute("QuestionResultDtos", qrds);
			 mav.addObject("questionresultdtos", qrds);
			 mav.addObject("exam", e);
			 mav.addObject("examdetail", ed);
			 mav.addObject("score", answer.getAnscore());
			 mav.addObject("usetime", answer.getAnusetime());
			 mav.setViewName("forward:/needlogin/examresultdetail.jsp");
			 return mav;
		 }
}
