package cn.pjc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pjc.dto.ResultMessage;
import cn.pjc.mapper.AcountMapper;
import cn.pjc.pojo.Acount;
import cn.pjc.util.IDHelper;

@Service
public class AcountService {
	@Autowired
	private AcountMapper am = null;
	
	public ResultMessage acountRegist(Acount a){
		List<Acount> acounts = this.am.selectAcountByAname(a.getAname());
		System.out.println(acounts);
		ResultMessage rm = new ResultMessage("", -1, false);
		if( acounts.size() > 0)
		{
			//说明已经被注册过了
			rm.setMessage("此用户名已经被注册过了");
			rm.setFlag(false);	
			return rm;
		}else
		{
			a.setAid(IDHelper.getUUID());//新生成一个主键id
			boolean saveresult = this.am.saveAcount(a);
			if(saveresult)
			{
				rm.setMessage("注册成功!!");
				rm.setFlag(true);
				return rm;
			}
		}
		return rm;
	}
	
	
	public ResultMessage acountLogin(Acount a)
	{
		List<Acount> acounts = this.am.selectAcountByAname(a.getAname());
		ResultMessage rm = new ResultMessage("系统错误", -1, false);
		if( acounts.size() > 0)
		{
			//说明找到了
			//继续对比密码
			Acount  acount = this.am.selectAcountByAnameAndApass(a);
			if(acount != null)
			{
				//说明密码正确
				rm.setFlag(true);
				rm.setMessage("登录成功");
			}else{
				rm.setFlag(false);
				rm.setMessage("密码错误");
			}
		}else{
			rm.setFlag(false);
			rm.setMessage("账号输入有误");
		}
		return rm;
	}
	
	
	

}
