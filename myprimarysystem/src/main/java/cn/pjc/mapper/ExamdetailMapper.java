package cn.pjc.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.pjc.pojo.Examdetail;

@Repository
public interface ExamdetailMapper {
	public boolean saveExamdetail(Examdetail examdetail);
	public List<Examdetail> selectAllExamdetail();
	public Examdetail selectExamdetailByExdid(String exdid);
	public boolean deleteExamdetailByExdid(String exdid);
	public boolean deleteExamdetailByExdnumber(String exdnumber);
	public int updateExamdetail(Examdetail examdetail); 
	
}
