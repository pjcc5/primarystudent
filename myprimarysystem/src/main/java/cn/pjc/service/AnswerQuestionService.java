package cn.pjc.service;

import java.util.List;

import cn.pjc.pojo.Answerquestion;


public interface AnswerQuestionService {
	public boolean saveAnswerQuestion(Answerquestion aq);
	public List<Answerquestion> queryAnswerquestionByAqnumber(String aqnumber);
}
