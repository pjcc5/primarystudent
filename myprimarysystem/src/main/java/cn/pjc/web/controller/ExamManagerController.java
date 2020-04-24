package cn.pjc.web.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.pjc.dto.ResultMessage;
import cn.pjc.pojo.Acount;
import cn.pjc.pojo.Exam;
import cn.pjc.pojo.Examdetail;
import cn.pjc.service.ExamService;
import cn.pjc.service.ExamdetailService;
import cn.pjc.util.IDHelper;


@Controller
@RequestMapping("/exam")
public class ExamManagerController {
	@Autowired
	private ExamService es= null;
	@Autowired
	private ExamdetailService eds= null;
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
		ModelAndView mav = new ModelAndView();
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
		if(result1 && result2)
		{
			rm.setFlag(true);
			rm.setMessage("删除套题成功");
		}
		return rm;
		
	}
	
}
