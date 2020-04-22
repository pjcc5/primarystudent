package cn.pjc.web.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.pjc.dto.ResultMessage;
import cn.pjc.pojo.Acount;
import cn.pjc.pojo.Exam;
import cn.pjc.pojo.Examdetail;
import cn.pjc.service.ExamService;
import cn.pjc.service.ExamdetailService;
import cn.pjc.service.impl.ExamServiceImpl;
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
			rm.setMessage("生成中,请稍等");
			rm.setFlagnum(-1);
			session.setAttribute("exdnumber", e.getExnumber());
		}
		return rm;
		
	}
	
	@ResponseBody
	@RequestMapping("/makeexamdetails.do")
	public ResultMessage makeexamdetails(Examdetail ed,HttpSession session)
	{
		ResultMessage rm = new ResultMessage("生成失败", -1, false);
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
}
