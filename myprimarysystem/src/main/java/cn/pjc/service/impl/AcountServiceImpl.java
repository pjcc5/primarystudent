package cn.pjc.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.pjc.dto.ResultMessage;
import cn.pjc.mapper.AcountMapper;
import cn.pjc.pojo.Acount;
import cn.pjc.service.AcountService;
import cn.pjc.util.IDHelper;

@Service
public class AcountServiceImpl  implements AcountService{
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
			a.setAcreatetime(new Timestamp(new Date().getTime()));
			a.setAlastchangetime(new Timestamp(new Date().getTime()));
			a.setAlevel(0);
			a.setArole(0);
			a.setAphoto("/myprimarysystem/images/userdefault.jpg");
			a.setAcontent("未设置简介");
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
	
	
	public ResultMessage acountLogin(HttpSession session,Acount a)
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
				//将账号存入session中
				session.setAttribute("acount", acount);
				System.out.println("登录:"+acount);
				
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
	
	//校验用户名和邮箱
	public boolean findpassvalidate(String findpassuname,String findpassemail)
	{
		List<Acount> acounts = this.am.selectAcountByAname(findpassuname);
		if( acounts.size() > 0)
		{
			//说明找到了
			//继续对比邮箱
			Acount  acount = acounts.get(0);
			if(acount.getAmail().equals(findpassemail) )
			{
				//说明邮箱正确
				return true;
				
			}
		}
		return false;
	}


	@Override
	public Acount queryAcountByAid(String aid) {
		return this.am.selectAcountByAid(aid);
		
	}


	@Override
	public boolean modifyAcount(Acount acount) {
		int a = this.am.updateAcount(acount);
		if(a > 0)
		{
			return true;
		}
		return false;
		 
	}


	@Override
	public Acount queryAcountByAname(String aname) {
		return this.am.selectAcountByAname(aname).get(0);
	}


	@Override
	public Acount queryAcountByAnameAndAmail(Acount a) {
		return this.am.selectAcountByAnameAndAmail(a);
	}
	
	
	

}
