package cn.pjc.web.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.pjc.dto.ResultMessage;
import cn.pjc.pojo.Acount;
import cn.pjc.pojo.Answer;
import cn.pjc.pojo.Answerquestion;
import cn.pjc.service.AnswerQuestionService;
import cn.pjc.service.AnswerService;
import cn.pjc.util.CustomTimestampEditor;
import cn.pjc.util.IDHelper;

@Controller
@RequestMapping("/answer")
public class AnswerManagerController {
	@InitBinder    
	public void initBinder(WebDataBinder binder) {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");    
	        dateFormat.setLenient(false);    
	        binder.registerCustomEditor(Timestamp.class, new CustomTimestampEditor(dateFormat, true));    
	}
	@Autowired
	private AnswerService as =null;
	@Autowired
	private AnswerQuestionService aqs = null;
	
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
			rm.setMessage(answer.getAnexamnumber());
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
			 ResultMessage rm = new ResultMessage("ok", -1, true);
			 //查出answer
			 Answer answer= this.as.queryAnswerByAnexamnumber(annumber);
			 int count = 0;
			 System.out.println("执行了算分");
			 while(answer == null)
			 {		
				 Thread.sleep(1000);
				 answer= this.as.queryAnswerByAnexamnumber(annumber);
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
			 List<Answerquestion> list = this.aqs.queryAnswerquestionByAqnumber(answer.getAnexamnumber());
			 for (Answerquestion answerquestion : list) {
				System.out.println(answerquestion);
			}
			 
			 
			 return rm;
		 }
}
