package cn.pjc.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.pjc.pojo.Question;

@Repository
public interface QuestionMapper {
	public boolean saveQuestion(Question question);
	public List<Question> selectAllQuestion();
	public Question selectQuestionByQid(String qid);
	public boolean deleteQuestionByQid(int qid);
	public int updateQuestion(Question question); 
	
	//附加的
	public List<Question> selectQuestionByQaid(Map<String, Object> map);
	
	//查询某人的题目总条数
	public int selectCountByQaid(String qaid);
}
