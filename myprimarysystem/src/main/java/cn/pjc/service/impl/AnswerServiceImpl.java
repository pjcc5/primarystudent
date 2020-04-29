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
	public List<Answer> queryAnswerByAnexamnumber(String anexamnumber) {
		return this.am.selectAnswerByAnexamnumber(anexamnumber);
	}

	@Override
	public boolean modifyAnswer(Answer answer) {
		int result = this.am.updateAnswer(answer);
		if(result > 0)
		{
			return true;
		}
		return false;
	}

	@Override
	public Answer queryAnswerByAnnumber(String annumber) {
		return this.am.selectAnswerByAnnumber(annumber);
	}

	@Override
	public boolean removeAnswerByAnnumber(String annumber) {
		return this.am.deleteAnswerByAnnumber(annumber);
	}

}
