package cn.pjc.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.pjc.pojo.Acount;

@Repository
public interface AcountMapper {
	public boolean saveAcount(Acount acount);
	public List<Acount> selectAllAcount();
	public Acount selectAcountByAid(String aid);
	public boolean deleteAcountByAid(int aid);
	public int updateAcount(Acount acount); 
	
}
