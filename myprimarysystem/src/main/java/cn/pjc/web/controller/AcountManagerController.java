package cn.pjc.web.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.pjc.dto.ResultMessage;
import cn.pjc.pojo.Acount;
import cn.pjc.service.AcountService;
import cn.pjc.util.EmailEntity;
import cn.pjc.util.Encryption;
import cn.pjc.util.SendMailUtils;

@Controller
@RequestMapping("/acount")
public class AcountManagerController {
	@Autowired
	private AcountService as = null;
	
	
	@RequestMapping("uregist.do")
	@ResponseBody
	public ResultMessage uregist(HttpSession session,Acount acount,String valicode)
	{	
		System.out.println(acount);
		System.out.println(valicode);
		String code =(String)session.getAttribute("code");
		if(valicode.toUpperCase().equals(code))
		{	
			acount.setApass(Encryption.toSecretKey(acount.getApass()));
			return as.acountRegist(acount);
		}
		else 
		{
			return new ResultMessage("验证码不正确", -1, false);
		}
	}
	
	
	@RequestMapping("ulogin.do")
	@ResponseBody
	public ResultMessage ulogin(HttpSession session,Acount acount)
	{	
		
		ResultMessage rm = new ResultMessage("系统错误", -1, false);
		if(acount != null && acount.getAname() != null && acount.getApass() != null)
		{
			acount.setApass(Encryption.toSecretKey(acount.getApass()));
		}
		return this.as.acountLogin(session,acount);
	}
	/**
	 * 退出登录方法
	 * @param session
	 * @param acount
	 * @return
	 */
	@RequestMapping("quit.do")
	@ResponseBody
	public ResultMessage quit(HttpSession session)
	{	
		session.removeAttribute("acount");
		ResultMessage rm = new ResultMessage("退出成功", -1, true);
		
		return rm;
	}
	/**
	 * 修改用户信息方法
	 * @param session
	 * @param acount
	 * @return
	 */
	@RequestMapping("edituser.do")
	public ModelAndView edituser(HttpServletRequest request, HttpServletResponse response, HttpSession session,Acount acount, MultipartFile file)
	{	
		System.out.println("页面拿到的"+acount);
		ModelAndView mav = new ModelAndView();
		boolean result = false;
		
		// 处理文件
				// 获取项目运行的路径
				String realPath = request.getSession().getServletContext()
						.getRealPath("/upload");
				// 判断该路径是否存在
				File realFile = new File(realPath);
				if (!realFile.exists()) {
					realFile.mkdirs();
					System.out.println("已创建upload文件夹");
				}
				String finalFileName = "";
				// 2. 获取唯一的文件名称(包含扩展名)
				String uuidName = UUID.randomUUID().toString().replace("-", "");
				// 获取扩展名: 获取文件名
				// 获取真实的文件名
				String originalFilename = file.getOriginalFilename();
				System.out.println(originalFilename);
				boolean uploadresult = false;//记录文件上传结果
				//如果用户选择了文件就进行上传
				if(originalFilename != null && !"".equals(originalFilename))
				{
					// 截取字符串，获取文件的扩展名
					String extendName = originalFilename.substring(originalFilename.lastIndexOf("."));
					System.out.println(extendName);
					// 唯一的文件名UUID.JPG
					String fileName = uuidName + extendName;
					System.out.println("fileName"+fileName);
					finalFileName = fileName;
					// 上传文件
					try {
						file.transferTo(new File(realFile, fileName));
						uploadresult =  true;
					} catch (IOException e) {
						e.printStackTrace();
					}
					Acount a_query = this.as.queryAcountByAid(acount.getAid());
					acount.setApass(a_query.getApass());
					acount.setAlastchangetime(new Timestamp(new Date().getTime()));
					acount.setArole(a_query.getArole());
					acount.setAlevel(a_query.getAlevel());
					acount.setAcreatetime(a_query.getAcreatetime());
					acount.setAphoto("/myprimarysystem/upload/"+finalFileName);
					result = this.as.modifyAcount(acount);
					
				}
				else{
					uploadresult =  false;
					Acount a_query = this.as.queryAcountByAid(acount.getAid());
					acount.setApass(a_query.getApass());
					acount.setAlastchangetime(new Timestamp(new Date().getTime()));
					acount.setArole(a_query.getArole());
					acount.setAlevel(a_query.getAlevel());
					acount.setAcreatetime(a_query.getAcreatetime());
					result = this.as.modifyAcount(acount);
				}
				
				if(result)
				{
					session.setAttribute("acount", acount);
					mav.addObject("message", "修改成功");
					
				}else
				{
					mav.addObject("message", "修改失败");
				}
				mav.setViewName("forward:/fale.jsp");
				return mav;
	}
	/**
	 * 申请老师方法
	 * @param session
	 * @param acount
	 * @return
	 */
	@RequestMapping("doteacher.do")
	@ResponseBody
	public ResultMessage doteacher(HttpSession session,String aid,String atruename,String aidcardnumber)
	{	
		ResultMessage rm = new ResultMessage("申请失败", -1, false);
		System.out.println(aid+"=="+atruename+"=="+aidcardnumber);
		Acount acount = this.as.queryAcountByAid(aid);
		System.out.println(acount);
		acount.setAidcardnumber(aidcardnumber);
		acount.setArole(1);
		acount.setAlastchangetime(new Timestamp(new Date().getTime()));
		boolean result  = this.as.modifyAcount(acount);
		if(result)
		{	
			session.setAttribute("acount", acount);
			rm.setMessage("申请成功!!");
			rm.setFlag(true);
		}
		return rm;
	}
	
	//修改密码
	@ResponseBody
	@RequestMapping("/modifypass.do")
	public ResultMessage modifypass(HttpSession session,String oldpass,String newpass)
	{	
		ResultMessage rm = new ResultMessage("修改密码失败", -1, false);
		Acount acount = (Acount)session.getAttribute("acount");
		if(oldpass == null || newpass==null)
		{
			return rm;
		}
		if(acount == null || acount.getAid() ==null )
		{	
			rm.setMessage("请重新登录");
			return rm;
		}
		String realpass = acount.getApass();
		oldpass = Encryption.toSecretKey(oldpass);
		newpass =Encryption.toSecretKey(newpass);
		if(!realpass.equals(oldpass))
		{
			rm.setMessage("原密码不正确");
			return rm;
		}
		acount.setApass(newpass);
		boolean result = this.as.modifyAcount(acount);
		if(result)
		{
			rm.setFlag(true);
			rm.setMessage("修改成功,请重新登录");
		}
		
		
		return rm;
	}
	
	@ResponseBody
	@RequestMapping("/findpassgetcode.do")
	public ResultMessage findpassgetcode(String findpassuname,String findpassemail,HttpSession session)
	{
		ResultMessage rm = new ResultMessage("信息有误", -1, false);
		boolean result = this.as.findpassvalidate(findpassuname, findpassemail);
		System.out.println("邮箱验证结果:"+result);
		if(result)
		{
			//开始发送邮件
			
			//验证码
			String[] str = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };
			Random r = new Random();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < 4; i++) {
				int index = r.nextInt(str.length);
				sb.append(str[index]);
			}
			String content = sb.toString();
			EmailEntity entity = new EmailEntity();
	        Properties props = new Properties();
	        props.setProperty("mail.debug", "true");
	        props.setProperty("mail.smtp.auth", "true");
	        props.setProperty("mail.host", "smtp.qq.com");
	        props.setProperty("mail.transport.protocol", "smtp");
	        entity.setProperties(props);
	        entity.setUserName("1783484759@qq.com");
	        entity.setPassword("hivkuqovqulxcffd");
	        entity.setSubject("国马教育");
	        entity.setText("【国马教育】验证码: "+content+" 该验证码仅用于身份验证,请勿泄露给他人使用");
	        entity.setFrom("1783484759@qq.com");
	        entity.setTo(findpassemail);
	        SendMailUtils.SendMail(entity);
			System.out.println("验证码为:"+content);
			session.removeAttribute("passvalicode");
			session.setAttribute("passvalicode", content);
			
			rm.setFlag(true);
			rm.setMessage("发送成功");
		}
		
		return rm;
	}
	//提交验证码,看邮箱验证是否正确
	@ResponseBody
	@RequestMapping("/validatethecode.do")
	public ResultMessage validatethecode(Acount a,String code,HttpSession session )
	{
		ResultMessage rm = new ResultMessage("验证失败", -1, false);
		if(a.getAname() == null || "".equals(a.getAname())||a.getAmail() == null || "".equals(a.getAmail())   ||  code == null || "".equals(code))
		{return rm;}
		Acount acount = this.as.queryAcountByAnameAndAmail(a);
		if(acount == null)
		{
			return rm;
		}
		String truecode = (String) session.getAttribute("passvalicode");
		if(truecode == null || "".equals(truecode))
		{
			return rm;
		}
		
		if(!truecode.equals(code))
		{
			rm.setMessage("验证码不正确");
			return rm;
		}
		else{
			rm.setFlag(true);
			session.setAttribute("ok", "ok");
			rm.setMessage("认证成功");
			
		}
		
		
//		//查询出
//		System.out.println(a);
//		System.out.println(code);
//		System.out.println(acount);
		return rm;
	}
	
	//修改密码(找回密码模块)
	@ResponseBody
	@RequestMapping("/editpasss.do")
	public ResultMessage editpasss(Acount acount,String pass ,HttpSession session )
	{
		ResultMessage rm = new ResultMessage("修改密码失败", -1, false);
		if(acount==null || acount.getAname() == null ||acount.getAmail() == null )
		{
			return rm;
		}
		String key = (String) session.getAttribute("ok");
		if(key==null || !"ok".equals(key) )
		{
			return rm;
		}
		Acount a = this.as.queryAcountByAnameAndAmail(acount);
		if(a == null)
		{
			return rm;
		}
		a.setApass(Encryption.toSecretKey(pass));
		System.out.println(a);
		boolean result = this.as.modifyAcount(a);
		if(result)
		{
			rm.setFlag(true);
			rm.setMessage("修改成功");
		}
		return rm;
	}
}
