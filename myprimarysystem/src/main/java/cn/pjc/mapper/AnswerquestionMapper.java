package cn.pjc.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.pjc.pojo.Answerquestion;

@Repository
public interface AnswerquestionMapper {
	public boolean saveAnswerquestion(Answerquestion answerquestion);
	public List<Answerquestion> selectAllAnswerquestion();
	public Answerquestion selectAnswerquestionByAqid(String aqid);
	public boolean deleteAnswerquestionByAqid(int aqid);
	public int updateAnswerquestion(Answerquestion answerquestion); 
	
}
