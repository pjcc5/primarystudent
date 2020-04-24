package cn.pjc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pjc.mapper.ExamMapper;
import cn.pjc.pojo.Exam;
import cn.pjc.service.ExamService;

@Service
public class ExamServiceImpl implements ExamService{
	@Autowired
	private ExamMapper em = null;

	@Override
	public boolean saveExam(Exam e) {
		
		return this.em.saveExam(e);
	}

	@Override
	public List<Exam> queryExamByExregister(String exregister) {
		return this.em.selectExamByExregister(exregister);
	}

	@Override
	public boolean removeExamByExid(String exid) {
		return this.em.deleteExamByExid(exid);
	}

	@Override
	public boolean removeExamByExnumber(String exnumber) {
		return this.em.deleteExamByExnumber(exnumber);
	}
	
	
	

}
