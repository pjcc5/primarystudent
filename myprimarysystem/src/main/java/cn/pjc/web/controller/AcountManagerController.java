package cn.pjc.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.pjc.dto.ResultMessage;
import cn.pjc.pojo.Acount;
import cn.pjc.service.AcountService;
import cn.pjc.util.Encryption;

@Controller
@RequestMapping("/acount")
public class AcountManagerController {
	@Autowired
	private AcountService as = null;
	
	
	@RequestMapping("uregist.do")
	@ResponseBody
	public ResultMessage uregist(HttpSession session,Acount acount,String valicode)
	{	
		System.out.println(acount);
		System.out.println(valicode);
		String code =(String)session.getAttribute("code");
		if(valicode.toUpperCase().equals(code))
		{	
			acount.setApass(Encryption.toSecretKey(acount.getApass()));
			return as.acountRegist(acount);
		}
		else 
		{
			return new ResultMessage("验证码不正确", -1, false);
		}
	}
	
	
	@RequestMapping("ulogin.do")
	@ResponseBody
	public ResultMessage ulogin(HttpSession session,Acount acount)
	{	
		ResultMessage rm = new ResultMessage("系统错误", -1, false);
		if(acount != null && acount.getAname() != null && acount.getApass() != null)
		{
			acount.setApass(Encryption.toSecretKey(acount.getApass()));
		}
		return this.as.acountLogin(session,acount);
	}
	/**
	 * 退出登录方法
	 * @param session
	 * @param acount
	 * @return
	 */
	@RequestMapping("quit.do")
	@ResponseBody
	public ResultMessage quit(HttpSession session)
	{	
		session.removeAttribute("acount");
		ResultMessage rm = new ResultMessage("退出成功", -1, true);
		
		return rm;
	}
}
