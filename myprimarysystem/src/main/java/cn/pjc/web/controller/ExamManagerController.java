package cn.pjc.web.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.pjc.dto.ResultMessage;
import cn.pjc.pojo.Acount;
import cn.pjc.pojo.Answer;
import cn.pjc.pojo.Exam;
import cn.pjc.pojo.Examdetail;
import cn.pjc.pojo.Question;
import cn.pjc.pojo.QuestionDto;
import cn.pjc.service.AcountService;
import cn.pjc.service.AnswerQuestionService;
import cn.pjc.service.AnswerService;
import cn.pjc.service.ExamService;
import cn.pjc.service.ExamdetailService;
import cn.pjc.service.QuestionService;
import cn.pjc.util.IDHelper;


@Controller
@RequestMapping("/exam")
public class ExamManagerController {
	@Autowired
	private ExamService es= null;
	@Autowired
	private ExamdetailService eds= null;
	@Autowired
	private QuestionService qs= null;
	@Autowired
	private AnswerService as= null;
	@Autowired
	private AnswerQuestionService aqs= null;
	@Autowired
	private AcountService acs= null;
	/*
	 * 生成套卷
	 */
	@ResponseBody
	@RequestMapping("/makeexam.do")
	public ResultMessage makeexam(String qgrade,String qsubject,int exlimittime,HttpSession session)
	{	
		ResultMessage rm = new ResultMessage("生成失败", -1, false);
		Acount acount = (Acount)session.getAttribute("acount") ;
		if(qgrade == null || qsubject ==null ||"".equals(qgrade.trim()) || "".equals(qsubject.trim()) )
		{
			return rm;
		}
		if(acount == null || acount.getAid() == null || "".equals(acount.getAid()))
		{
			return rm;
		}
		Exam e = new Exam();
		e.setExid(IDHelper.getUUID());
		e.setExnumber(IDHelper.getUUID());
		e.setExregister(acount.getAname());
		e.setExregisttime(new Timestamp(new Date().getTime()));
		e.setExlimittime(exlimittime);
		System.out.println(e);
		boolean result = this.es.saveExam(e);
		if(result)
		{
			rm.setFlag(true);
			rm.setMessage(e.getExnumber());
			rm.setFlagnum(-1);
		}
		return rm;
		
	}
	
	@ResponseBody
	@RequestMapping("/makeexamdetails.do")
	public ResultMessage makeexamdetails(Examdetail ed,HttpSession session)
	{
		ResultMessage rm = new ResultMessage("生成失败", -1, false);
		System.out.println(ed);
		ed.setExdid(IDHelper.getUUID());
		boolean result = this.eds.saveExamDetail(ed);
		if(result)
		{
			session.setAttribute("saveresult", true);
			rm.setFlag(true);
			rm.setMessage("ok");
			rm.setFlagnum(-1);
			return rm;
		}
		session.setAttribute("saveresult", false);
		return rm;
	}
	/**
	 * 显示我的题库
	 */
	@ResponseBody
	@RequestMapping("/showmyexams.do")
	public List<Exam> showmyexams(HttpSession session,String target)
	{
		Acount acount = (Acount)session.getAttribute("acount");
		System.out.println(acount);
		List<Exam> list=null;
		if(acount == null || "".equals(acount.getAid().trim()))
		{
			return null;
		}
		if( "true".equals(target))
		{
			System.out.println(acount.getAname());
			    list= this.es.queryExamByExregister(acount.getAname());
				System.out.println(list);
			
		}
		
		return list;
	}
	
	/**
	 * 删除套题方法,只有老师才能删除
	 */
	@ResponseBody
	@RequestMapping("/deleteexams.do")
	public ResultMessage deleteexams(HttpSession session,String exnumber)
	{
		Acount acount = (Acount)session.getAttribute("acount");
		ResultMessage rm = new ResultMessage("删除失败", -1, false);
		if(acount == null || "".equals(acount.getAid()) || acount.getArole() != 1)
		{
			rm.setMessage("只有老师能删除");
			return rm;
		}
		
		boolean result1 = this.eds.removeExamdetailByExdnumber(exnumber);
		boolean result2 = this.es.removeExamByExnumber(exnumber);
		boolean result3 = true;
		List<Answer>  answers = this.as.queryAnswerByAnexamnumber(exnumber);
		for (Answer answer : answers) {
			String annumber = answer.getAnnumber();
			result3 = this.aqs.removeAnswerquestionByAqnumber(annumber);
			result3 =  this.as.removeAnswerByAnnumber(annumber);
		}
		
		
		
		if(result1 && result2 && result3)
		{
			rm.setFlag(true);
			rm.setMessage("删除套题成功");
		}
		return rm;
		
	}
	
	/**
	 * 根据考试id生成试题返回到页面上
	 * register 是出题人的id
	 */
	 @RequestMapping("/doexam.do")
	 public ModelAndView doexam(String exdnumber,HttpSession session,String register)
	 {
		 System.out.println(register);
		 ModelAndView mav =new ModelAndView();
		 //出题人
		 Acount regacount =  this.acs.queryAcountByAname(register);
		 //答题人
		 Acount acount = (Acount)session.getAttribute("acount");
		 
		 if(exdnumber == null || acount==null || "".equals(acount.getAid()) || "".equals(exdnumber.trim()))
		 {
			 mav.setViewName("redirect:/");
			 return mav;
		 }
		 
		 //查出这场考试exam
		 Exam e =  this.es.queryExamByExdnumber(exdnumber);
		 //查出这场考试的分类及他们的数目
		 List<Examdetail> list = this.eds.queryExamdetailByExdnumber(exdnumber);
		 List<Question> questions = getQuestions(regacount,e,list);
		 mav.addObject("questions", questions);
		 mav.addObject("exam", e);//存入这场考试相关的信息
		 mav.setViewName("forward:/needlogin/domyexam.jsp");//转跳到考试页面
		 mav.addObject("exdgrade", list.get(0).getExdgrade());
		 mav.addObject("exdsubject", list.get(0).getExdsubject());
		 
		 return mav;
		 
	 }
	 /**
	  * 根据考试id生成试题返回到页面上
	  * register 是出题人的id
	  */
	 @RequestMapping("/domyexam.do")
	 public ModelAndView pjc123(String exdnumber,HttpSession session)
	 {
		 ModelAndView mav =new ModelAndView();
		 //答题人
		 Acount acount = (Acount)session.getAttribute("acount");
		 
		 if(exdnumber == null || acount==null || "".equals(acount.getAid()) || "".equals(exdnumber.trim()))
		 {
			 mav.setViewName("redirect:/");
			 return mav;
		 }
		 
		 //查出这场考试exam
		 Exam e =  this.es.queryExamByExdnumber(exdnumber);
		 //查出这场考试的分类及他们的数目
		 List<Examdetail> list = this.eds.queryExamdetailByExdnumber(exdnumber);
		 List<Question> questions = getQuestions(acount,e,list);
		 mav.addObject("questions", questions);
		 mav.addObject("exam", e);//存入这场考试相关的信息
		 mav.setViewName("forward:/needlogin/domyexam.jsp");//转跳到考试页面
		 mav.addObject("exdgrade", list.get(0).getExdgrade());
		 mav.addObject("exdsubject", list.get(0).getExdsubject());
		 
		 return mav;
		 
	 }
	
	 
	 public List<Question> getQuestions(Acount acount,Exam e,List<Examdetail> exds)
	 {	
		 List<Question> result = new ArrayList<Question>();
		 for (Examdetail examdetail : exds) {
			int neednum = examdetail.getExdamount();
			if(neednum == 0)
			{
				continue;
			}
			//查询出这种分类所有题目数量
			Map<String,Object> map = new HashMap<>();
			map.put("qaid", acount.getAid());
			map.put("qgrade", examdetail.getExdgrade());
			map.put("qsubject", examdetail.getExdsubject());
			map.put("exdtype", examdetail.getExdtype());
			List<QuestionDto> list =  this.qs.queryQuestionDto(map);
			//所有这种分类的题目集合
			List<Question> questionlist = this.qs.queryQuestionByQtypeAndQsubjectAndQaidAndExdtype(map);
			System.out.println("所有题目大小:"+questionlist.size());
			System.out.println(list);
			
			int maxnumber = getmaxcont(examdetail,list);
			Random random = new Random();
			HashSet<Integer> hs = new HashSet<Integer>();
	 
			while(hs.size() < neednum){
				hs.add(random.nextInt(maxnumber)+1);
			}
			for (Integer integer : hs) {
				result.add(questionlist.get(integer-1));
			}
			
			
			
			
		}
		 return result;
	 }
	 //求出题目详情对应的分类总共有多少道题
	 public int getmaxcont(Examdetail ed,List<QuestionDto> list)
	 {
		for (QuestionDto questionDto : list) {
			System.out.println(ed.getExdtype() +"...."+ questionDto.getClassificationname());
			if(ed.getExdtype() .equals(questionDto.getClassificationname()))
			{
				return questionDto.getClassificationcount();
			}
			
		}
		return 0;
	 }
	 
	 /**
	  * 搜索题库的方法:只支持查询老师
	  */
	 @ResponseBody
	 @RequestMapping("/{pagenum}/findexam.do")
	 public Object findexam(@PathVariable("pagenum") int pagenum, String keywords)
	 {			
		 System.out.println(keywords);
		 //开始分页
		 if(keywords == null || "".equals(keywords))
		 {
			 return null;
		 }
		 //求出总题目数
		 int count = this.es.queryCountLikeExregister(keywords);
		 System.out.println("总题数是:"+count);
		 int nextcount = 0;
		 int n = 1;//最大页数
		 if(pagenum <=0)
			{
				pagenum =1;
			}
			if(count == 0)
			{
				
			}
			
			else{
				//最大页数
				n = (count % 10) >0 ? (count / 10 + 1):(count / 10 );
				System.out.println("最大页数"+n);
				 nextcount =  pagenum*10;
				if(nextcount > count)
				{
					//到了最后一页
					nextcount = count;
				}
				if(pagenum > n)
				{
					pagenum = n;
				}
				}
			int begin = (pagenum-1)*10;
			int end = nextcount;
			System.out.println("bengin:"+begin+"end"+end);
			Map<String, Object> map = new HashMap<String, Object>();
			 map.put("keywords", keywords);
			 map.put("begin", begin);
			 map.put("end", end);
			 List<Exam> exams = this.es.selectExamLikeExregister(map);
		 return exams;
		 
	 }
	 
	 
}
