package cn.pjc.web.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.pjc.dto.ResultMessage;
import cn.pjc.pojo.Acount;
import cn.pjc.pojo.Exam;
import cn.pjc.pojo.Question;
import cn.pjc.pojo.QuestionDto;
import cn.pjc.service.QuestionService;
import cn.pjc.util.IDHelper;


@Controller
@RequestMapping("/question")
public class QuestionManagerController {
	@Autowired
	private QuestionService qs = null;
	
	@RequestMapping("/uploadsubject.do")
	@ResponseBody
	public ResultMessage uploadsubject(Question question,HttpSession session){
		ResultMessage  rm = new ResultMessage("登记失败", -1, false);
		
		question.setQid(IDHelper.getUUID());
		question.setQchangetime(new Timestamp(new Date().getTime()));
		question.setQregisttime(new Timestamp(new Date().getTime()));
		//这里应该判断试题是否重复提交(同一个人,相同题干)
		
		//保存试题
		boolean result = this.qs.saveQuestion(question);
		if(result){
			rm.setFlag(true);
			rm.setMessage("登记成功");
		}
		return rm;
		
	}
	
	@RequestMapping("/{pagenum}/showmysubject.do")
	public ModelAndView showmysubject(String ccc,@PathVariable("pagenum") int pagenum,HttpSession session){
		ModelAndView mav = new ModelAndView();
		
		if(ccc==null || "".equals(ccc))
		{
			mav.setViewName("redirect:/");//返回主页
			return mav;
		}
		
		//查询出此用户的所有题目
		int count = this.qs.queryCountByQaid(ccc);
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
			
			}
		
		int begin = (pagenum-1)*10;
		int end = nextcount;
		System.out.println("bengin:"+begin+"end"+end);
		//查询数据
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("qaid", ccc);
		map.put("begin", begin);
		map.put("end", end);
		List<Question> list = this.qs.queryQuestionByQaid(map);
		session.setAttribute("maxpage", n);
		session.setAttribute("subjects", list);
		session.setAttribute("nextpage", pagenum);
//		mav.addObject("maxpage", n);
//		mav.addObject("subjects", list);
//		mav.addObject("nextpage", pagenum);
		mav.setViewName("redirect:/needlogin/showmysubject.jsp");
		return mav;
		
	}
	
	/**
	 * 传入qid
	 * @param aaa 是qidquestion表的主键
	 * 返回查询出来的问题详情显示在页面上方便修改
	 */
	@RequestMapping("/questiondetails.do")
	public ModelAndView questiondetails(String aaa,HttpSession session)
	{
		if(aaa == null || "".equals(aaa))
		{
			return null;
		}
		ModelAndView mav = new ModelAndView();
		Question question = this.qs.queryQuestionByQid(aaa);
		
		if(question != null && !"".equals(question.getQaid()) )
		{
			mav.setViewName("redirect:/needlogin/subjectdetail.jsp");
//			mav.addObject("question",question);
			session.setAttribute("question", question);
			return mav;
		}
		
		return null;
	}
	
	@ResponseBody
	@RequestMapping("/editsubject.do")
	public ResultMessage editsubject(Question question,HttpSession session)
	{
		ResultMessage rm = new ResultMessage("修改失败", -1, false);
		
		Question question_query = this.qs.queryQuestionByQid(question.getQid());
		if(question_query == null)
		{
			return rm;
		}
		question.setQchangetime(question_query.getQchangetime());
		question.setQregisttime(question_query.getQregisttime());
		//开始修改
		boolean result = this.qs.modifyQuestion(question);
		if(result)
		{
			rm.setFlag(true);
			rm.setMessage("修改成功");
			session.setAttribute("question", question);
		}
		return rm;
	}
	
	
	@ResponseBody
	@RequestMapping("/deletesubject.do")
	public ResultMessage deletesubject(String aaa,HttpSession session)
	{
		ResultMessage rm = new ResultMessage("删除失败", -1, false);
		if(aaa == null || "".equals(aaa))
		{
			return rm;
		}
		
		Question question = this.qs.queryQuestionByQid(aaa);
		if(question == null)
		{
			return rm;
		}
		boolean result = this.qs.removeQuestionByQid(aaa);
		if(result)
		{
			
			List<Question> list =(List<Question>)session.getAttribute("subjects");
			for(int i =0; i< list.size(); i++)
			{
				if(list.get(i).getQid() .equals(aaa))
				{	
					list.remove(i);
				}
			}
			session.setAttribute("subjects", list);
			rm.setFlag(true);
			rm.setMessage("删除成功");
			
			
		}
		return rm;
		
	}
	
	/*
	 * 去创建套卷页面
	 */
	@RequestMapping("/makeexam.do")
	public ModelAndView makeexam(HttpSession session)
	{
		ModelAndView mav = new ModelAndView();
		Acount acount = (Acount) session.getAttribute("acount");
		if(acount == null || acount.getArole() != 1)
		{
			mav.setViewName("redirect:/");
		}
//		//拿到此人所有的题目
//		List<Question> questions = this.qs.queryAllQuestionByQaid(acount.getAid());
//		//得到所有题目分类
//		
		mav.setViewName("forward:/needlogin/makeexam.jsp");
		return mav;
	}
	
	/*
	 * 获得分类和学科的所有题目分类以及他们的数目
	 */
	@ResponseBody
	@RequestMapping("/getexamdetails.do")
	public Object getexamdetails(String qgrade,String qsubject,HttpSession session)
	{
		Acount acount = (Acount)session.getAttribute("acount");
		if(acount == null || "".equals(acount.getAid()))
		{
			return null;
		}
//		String aid = acount.getAid();
//		Map<String, Object> map = new HashMap<>();
//		map.put("qaid", aid);
//		map.put("qgrade", qgrade);
//		map.put("qsubject", qsubject);
//		List<Question> list = this.qs.queryQuestionByQtypeAndQsubjectAndQaid(map);
//		
		String aid = acount.getAid();
		Map<String, Object> map = new HashMap<>();
		map.put("qaid", aid);
		map.put("qgrade", qgrade);
		map.put("qsubject", qsubject);
		List<QuestionDto> list= this.qs.queryQuestionDto(map);
		return list;
		
	}
	
	
}
