package cn.pjc.service;

import java.util.List;
import java.util.Map;

import cn.pjc.dto.ResultMessage;
import cn.pjc.pojo.Question;


public interface QuestionService {
	public boolean saveQuestion(Question question);
	public List<Question> queryQuestionByQaid(Map<String, Object> map);
	public int queryCountByQaid(String qid);
	public Question queryQuestionByQid(String qid);
	public boolean modifyQuestion(Question question);
}
