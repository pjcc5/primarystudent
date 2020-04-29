package cn.pjc.service;

import java.util.List;
import java.util.Map;

import cn.pjc.pojo.Answerquestion;


public interface AnswerQuestionService {
	public boolean saveAnswerQuestion(Answerquestion aq);
	public boolean removeAnswerquestionByAqnumber(String aqnumber);
	public List<Answerquestion> queryAnswerquestionByAqnumber(String aqnumber);
	public Answerquestion queryAnswerquestionByAqnumberAndAqquestionid(Map<String,Object> map);
}
