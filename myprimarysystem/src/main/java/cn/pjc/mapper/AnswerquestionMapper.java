package cn.pjc.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.pjc.pojo.Answerquestion;

@Repository
public interface AnswerquestionMapper {
	public boolean saveAnswerquestion(Answerquestion answerquestion);
	public List<Answerquestion> selectAllAnswerquestion();
	public Answerquestion selectAnswerquestionByAqid(String aqid);
	public List<Answerquestion> selectAnswerquestionByAqnumber(String aqnumber);
	public Answerquestion selectAnswerquestionByAqnumberAndAqquestionid(Map<String,Object> map);
	public boolean deleteAnswerquestionByAqid(String aqid);
	public boolean deleteAnswerquestionByAqnumber(String aqnumber);
	public int updateAnswerquestion(Answerquestion answerquestion); 
	
}
