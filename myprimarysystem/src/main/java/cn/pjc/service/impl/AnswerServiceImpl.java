package cn.pjc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pjc.mapper.AnswerMapper;
import cn.pjc.pojo.Answer;
import cn.pjc.service.AnswerService;
@Service
public class AnswerServiceImpl implements AnswerService{
	@Autowired
	private AnswerMapper am =null;

	@Override
	public boolean saveAnswer(Answer answer) {
		return this.am.saveAnswer(answer);
	}

	@Override
	public List<Answer> queryAnswerByAnname(String anname) {
		return this.am.selectAnswerByAnname(anname);
	}

	@Override
	public Answer queryAnswerByAnexamnumber(String anexamnumber) {
		return this.am.selectAnswerByAnexamnumber(anexamnumber);
	}

}
