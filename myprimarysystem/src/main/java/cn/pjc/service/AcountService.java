package cn.pjc.service;

import javax.servlet.http.HttpSession;

import cn.pjc.dto.ResultMessage;
import cn.pjc.pojo.Acount;

public interface AcountService {
	public ResultMessage acountRegist(Acount a);
	public ResultMessage acountLogin(HttpSession session,Acount a);
	public Acount queryAcountByAid(String aid);
	public Acount queryAcountByAname(String aname);
	public boolean modifyAcount(Acount acount);
	public boolean findpassvalidate(String findpassuname,String findpassemail);
	public Acount queryAcountByAnameAndAmail(Acount a);
}
