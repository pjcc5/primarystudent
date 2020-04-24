package cn.pjc.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pjc.mapper.QuestionMapper;
import cn.pjc.pojo.Question;
import cn.pjc.pojo.QuestionDto;
import cn.pjc.service.QuestionService;
@Service
public class QuestionServiceImpl implements QuestionService{
	@Autowired
	private QuestionMapper qm = null;
	
	@Override
	public boolean saveQuestion(Question question) {
		return this.qm.saveQuestion(question);
	}

	@Override
	public List<Question> queryQuestionByQaid(Map<String, Object> map) {
		return this.qm.selectQuestionByQaid(map);
	}

	@Override
	public int queryCountByQaid(String qaid) {
		return this.qm.selectCountByQaid(qaid);
	}

	@Override
	public Question queryQuestionByQid(String qid) {
		return this.qm.selectQuestionByQid(qid);
	}

	@Override
	public boolean modifyQuestion(Question question) {
		int result = this.qm.updateQuestion(question);
		if(result > 0)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean removeQuestionByQid(String qid) {
		return this.qm.deleteQuestionByQid(qid);
	}

	@Override
	public List<Question> queryAllQuestionByQaid(String qaid) {
		return this.qm.selectAllQuestionByQaid(qaid);
	}

	@Override
	public List<Question> queryQuestionByQtypeAndQsubjectAndQaid(Map<String, Object> map) {
		
		return this.qm.selectQuestionByQtypeAndQsubjectAndQaid(map);
	}

	@Override
	public List<QuestionDto> queryQuestionDto(Map<String, Object> map) {
		return this.qm.selectQuestionDto(map);
	}

	@Override
	public List<Question> queryQuestionByQtypeAndQsubjectAndQaidAndExdtype(
			Map<String, Object> map) {
		return this.qm.selectQuestionByQtypeAndQsubjectAndQaidAndExdtype(map);
	}
	

}
