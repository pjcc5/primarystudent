package cn.pjc.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.pjc.pojo.Acount;
import cn.pjc.service.AcountService;

@Controller
@RequestMapping("/acount")
public class AcountManagerController {
	@Autowired
	private AcountService as = null;
	
	
	@RequestMapping("uregist.do")
	@ResponseBody
	public boolean uregist(Acount acount)
	{
		return as.acountRegist(acount);
	}
	
}
