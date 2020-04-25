package cn.pjc.web.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.pjc.dto.ResultMessage;
import cn.pjc.pojo.Answer;
import cn.pjc.service.AnswerQuestionService;
import cn.pjc.service.AnswerService;
import cn.pjc.util.CustomTimestampEditor;

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
	
	
	@RequestMapping("/saveanswer")
	public ResultMessage saveanswer(Answer answer)
	{
		ResultMessage rm = new ResultMessage("", -1, false);
		System.out.println(answer);
		return rm;
	}
	
}
