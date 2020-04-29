package cn.pjc.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.pjc.dto.ResultMessage;
import cn.pjc.pojo.Acount;
import cn.pjc.pojo.Answer;

public interface AnswerService {
	public boolean saveAnswer(Answer answer);
	public boolean modifyAnswer(Answer answer);
	public boolean removeAnswerByAnnumber(String annumber);
	public List<Answer> queryAnswerByAnname(String anname);
	public List<Answer> queryAnswerByAnexamnumber(String anexamnumber);
	public Answer queryAnswerByAnnumber(String annumber);
}
