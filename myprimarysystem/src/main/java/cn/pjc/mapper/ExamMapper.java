package cn.pjc.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.pjc.pojo.Exam;

@Repository
public interface ExamMapper {
	public boolean saveExam(Exam exam);
	public List<Exam> selectAllExam();
	public Exam selectExamByExid(String exid);
	public Exam selectExamByExnumber(String exnumber);
	public boolean deleteExamByExid(String exid);
	public boolean deleteExamByExnumber(String exnumber);
	public int updateExam(Exam exam); 
	//附加
	public List<Exam> selectExamByExregister(String exregister);
	
	
}
