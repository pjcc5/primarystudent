package cn.pjc.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.pjc.pojo.Answer;

@Repository
public interface AnswerMapper {
	public boolean saveAnswer(Answer answer);
	public List<Answer> selectAllAnswer();
	public Answer selectAnswerByAnid(String anid);
	public List<Answer> selectAnswerByAnexamnumber(String anexamnumber);
	public boolean deleteAnswerByAnid(String anid);
	public boolean deleteAnswerByAnnumber(String annumber);
	public int updateAnswer(Answer answer); 
	
	
	public List<Answer> selectAnswerByAnname(String anname);
	public Answer selectAnswerByAnnumber(String annumber);
}
