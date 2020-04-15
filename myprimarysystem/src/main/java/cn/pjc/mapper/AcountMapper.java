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
	
	//补充一些方法
	/**
	 * 查看账户是否存在
	 */
	public List<Acount> selectAcountByAname(String aname);
	
	
	/**
	 * 根据用户名和密码查询账号
	 */
	public Acount selectAcountByAnameAndApass(Acount acount);
}
