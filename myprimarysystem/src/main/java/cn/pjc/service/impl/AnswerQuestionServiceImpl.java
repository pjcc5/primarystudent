package cn.pjc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pjc.mapper.AnswerquestionMapper;
import cn.pjc.pojo.Answerquestion;
import cn.pjc.service.AnswerQuestionService;
@Service
public class AnswerQuestionServiceImpl implements AnswerQuestionService{
	@Autowired
	private AnswerquestionMapper aqm = null;
	@Override
	public boolean saveAnswerQuestion(Answerquestion aq) {
		return this.aqm.saveAnswerquestion(aq);
	}
	@Override
	public List<Answerquestion> queryAnswerquestionByAqnumber(String aqnumber) {
		return this.aqm.selectAnswerquestionByAqnumber(aqnumber);
	}

}
