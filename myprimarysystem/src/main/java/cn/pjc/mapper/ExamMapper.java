package cn.pjc.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.pjc.pojo.Exam;

@Repository
public interface ExamMapper {
	public boolean saveExam(Exam exam);
	public List<Exam> selectAllExam();
	public Exam selectExamByExid(String exid);
	public boolean deleteExamByExid(int exid);
	public int updateExam(Exam exam); 
	
}
