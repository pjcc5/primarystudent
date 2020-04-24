package cn.pjc.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.pjc.pojo.Question;
import cn.pjc.pojo.QuestionDto;

@Repository
public interface QuestionMapper {
	public boolean saveQuestion(Question question);
	public List<Question> selectAllQuestion();
	public List<Question> selectAllQuestionByQaid(String qaid);//查询某人的所有题目
	public Question selectQuestionByQid(String qid);
	public boolean deleteQuestionByQid(String qid);
	public int updateQuestion(Question question); 
	
	//附加的
	public List<Question> selectQuestionByQaid(Map<String, Object> map);
	
	//查询某人的题目总条数
	public int selectCountByQaid(String qaid);
	//查询某人的题目分类
	public List<Question> selectQuestionByQtypeAndQsubjectAndQaid(Map<String, Object> map);
	public List<Question> selectQuestionByQtypeAndQsubjectAndQaidAndExdtype(Map<String, Object> map);
	//查询分类
	public List<QuestionDto> selectQuestionDto(Map<String, Object> map);
}
