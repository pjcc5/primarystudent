package cn.pjc.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.pjc.pojo.Answer;

@Repository
public interface AnswerMapper {
	public boolean saveAnswer(Answer answer);
	public List<Answer> selectAllAnswer();
	public Answer selectAnswerByAnid(String anid);
	public Answer selectAnswerByAnexamnumber(String anexamnumber);
	public boolean deleteAnswerByAnid(int anid);
	public int updateAnswer(Answer answer); 
	
	
	public List<Answer> selectAnswerByAnname(String anname);
}
