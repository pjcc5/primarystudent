package cn.pjc.service;

import java.util.List;

import cn.pjc.pojo.Exam;



public interface ExamService {
	public boolean saveExam(Exam e);
	public boolean removeExamByExid(String exid);
	public boolean removeExamByExnumber(String exnumber);
	public List<Exam> queryExamByExregister(String exregister);
	public Exam queryExamByExdnumber(String exdnumber);
}
