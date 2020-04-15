package cn.pjc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pjc.mapper.AcountMapper;
import cn.pjc.pojo.Acount;
import cn.pjc.util.IDHelper;

@Service
public class AcountService {
	@Autowired
	private AcountMapper am = null;
	
	public boolean acountRegist(Acount a){
		Acount acount = this.am.selectAcountByAname(a.getAname());
		if(acount != null)
		{
			//说明已经被注册过了
			return false;
		}else
		{
			a.setAid(IDHelper.getUUID());//新生成一个主键id
			boolean saveresult = this.am.saveAcount(a);
			if(saveresult)
			{
				return true;
			}
		}
		return false;
	}
	
	
	public boolean acountLogin()
	{
		return false;
	}
	
	
	

}
