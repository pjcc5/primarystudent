package cn.pjc.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.pjc.dto.ResultMessage;
import cn.pjc.pojo.Acount;
import cn.pjc.service.AcountService;
import cn.pjc.util.Encryption;

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
	@ResponseBody
	public ResultMessage edituser(HttpServletRequest request, HttpServletResponse response, HttpSession session,Acount acount, MultipartFile file)
	{	
		System.out.println(acount);
		ResultMessage rm = new ResultMessage("退出成功", -1, true);
		
		
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
				// 2. 获取唯一的文件名称(包含扩展名)
				String uuidName = UUID.randomUUID().toString().replace("-", "");
				// 获取扩展名: 获取文件名
				// 获取真实的文件名
				String originalFilename = file.getOriginalFilename();
				System.out.println(originalFilename);
				// 截取字符串，获取文件的扩展名
				String extendName = originalFilename.substring(originalFilename.lastIndexOf("."));
				System.out.println(extendName);
				// 唯一的文件名UUID.JPG
				String fileName = uuidName + extendName;
				// 上传文件
				try {
					file.transferTo(new File(realFile, fileName));
				} catch (IOException e) {
					e.printStackTrace();
				}

				return rm;
	}
	
}
