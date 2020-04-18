package cn.pjc.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.pjc.dto.ResultMessage;
import cn.pjc.pojo.Question;
import cn.pjc.service.QuestionService;


@Controller
@RequestMapping("/question")
public class QuestionManagerController {
	@Autowired
	private QuestionService qs = null;
	
	@RequestMapping("/uploadsubject.do")
	@ResponseBody
	public ResultMessage uploadsubject(Question question){
		ResultMessage  rm = new ResultMessage("登记成功", -1, false);
		System.out.println(question);
		return rm;
		
	}
}
