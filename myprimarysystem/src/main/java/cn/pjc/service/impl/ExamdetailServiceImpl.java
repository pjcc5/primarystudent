package cn.pjc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pjc.mapper.ExamdetailMapper;
import cn.pjc.pojo.Examdetail;
import cn.pjc.service.ExamdetailService;

@Service
public class ExamdetailServiceImpl implements ExamdetailService{
	@Autowired
	private ExamdetailMapper em= null;
	@Override
	public boolean saveExamDetail(Examdetail ed) {
		return this.em.saveExamdetail(ed);
	}
	@Override
	public boolean removeExamdetailByExdid(String exdid) {
		return this.em.deleteExamdetailByExdid(exdid);
	}
	@Override
	public boolean removeExamdetailByExdnumber(String exdnumber) {
		return this.em.deleteExamdetailByExdnumber(exdnumber);
	}

}
