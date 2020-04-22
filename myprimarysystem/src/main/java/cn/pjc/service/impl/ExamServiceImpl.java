package cn.pjc.service.impl;

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
	
	
	

}
