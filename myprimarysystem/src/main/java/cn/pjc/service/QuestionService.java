package cn.pjc.service;

import java.util.List;
import java.util.Map;

import cn.pjc.dto.ResultMessage;
import cn.pjc.pojo.Question;
import cn.pjc.pojo.QuestionDto;


public interface QuestionService {
	public boolean saveQuestion(Question question);
	public List<Question> queryQuestionByQaid(Map<String, Object> map);
	public List<Question> queryAllQuestionByQaid(String qaid);
	public int queryCountByQaid(String qid);
	public Question queryQuestionByQid(String qid);
	public boolean modifyQuestion(Question question);
	public boolean removeQuestionByQid(String qid);
	public List<Question> queryQuestionByQtypeAndQsubjectAndQaid(Map<String, Object> map);
	public List<QuestionDto> queryQuestionDto(Map<String, Object> map);
}
