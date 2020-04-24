package cn.pjc.service;

import java.util.List;

import cn.pjc.pojo.Examdetail;



public interface ExamdetailService {
	public boolean saveExamDetail(Examdetail ed);
	public boolean removeExamdetailByExdid(String exdid);
	public boolean removeExamdetailByExdnumber(String exdnumber);
	public List<Examdetail> queryExamdetailByExdnumber(String exdnumber);
}
