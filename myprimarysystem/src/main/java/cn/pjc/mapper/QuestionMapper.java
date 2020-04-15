package cn.pjc.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.pjc.pojo.Question;

@Repository
public interface QuestionMapper {
	public boolean saveQuestion(Question question);
	public List<Question> selectAllQuestion();
	public Question selectQuestionByQid(String qid);
	public boolean deleteQuestionByQid(int qid);
	public int updateQuestion(Question question); 
	
}
