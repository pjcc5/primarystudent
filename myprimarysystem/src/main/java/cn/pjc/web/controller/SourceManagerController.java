package cn.pjc.web.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.pjc.dto.ResultMessage;
import cn.pjc.pojo.Acount;
import cn.pjc.pojo.Exam;
import cn.pjc.pojo.Source;
import cn.pjc.service.SourceService;
import cn.pjc.util.IDHelper;

@Controller
@RequestMapping("/source")
public class SourceManagerController {
	@Autowired
	private SourceService ss = null;
	
	@RequestMapping("/savesource.do")
	public ModelAndView insertSource(Source s,HttpSession session,HttpServletRequest request ,HttpServletResponse response,MultipartFile file)
	{
		ModelAndView mav = new ModelAndView();
		System.out.println(s);
		String originalFilename = file.getOriginalFilename();//文件的真实名称如aaa.txt
		boolean uploadresult = false;//记录文件上传结果
		//创建资源文件夹
				// 获取项目运行的路径
				String realPath = session.getServletContext()
						.getRealPath("/sources");
				// 判断该路径是否存在
				File realFile = new File(realPath);
				if (!realFile.exists()) {
					realFile.mkdirs();
					System.out.println("已创建sources文件夹");
				}
		System.out.println(session.getServletContext()
						.getRealPath("/"));
		
		//如果得到的文件名不为null就开始上传
		if(originalFilename != null && !"".equals(originalFilename))
		{
			//得到后缀名
			String extendName = originalFilename.substring(originalFilename.lastIndexOf("."));
			// 2. 获取唯一的文件名称(包含扩展名)
			String uuidName = UUID.randomUUID().toString().replace("-", "");
			String fileName = uuidName + extendName;//要保存的文件名
			// 上传文件
			try {
				file.transferTo(new File(realFile, fileName));
				uploadresult =  true;
				System.out.println("文件保存成功:"+realFile+fileName	);
				//保存文件信息
				s.setSid(IDHelper.getUUID());
				s.setSpublishtime(new Timestamp(new Date().getTime()));
				s.setSchangetime(new Timestamp(new Date().getTime()));
				s.setSdownloadtimes(0);
				s.setSurl("/myprimarysystem/sources/"+fileName);
				boolean result =this.ss.saveSource(s);
				if(result)
				{
					mav.addObject("uploadmessage", "上传文件成功");
					mav.setViewName("forward:/fileuploadresult.jsp");
					return mav;
				}else
				{
					mav.addObject("uploadmessage", "文件上传失败(保存)");
					mav.setViewName("forward:/fileuploadresult.jsp");
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			//文件名不合法
			mav.addObject("uploadmessage", "文件上传失败");
			mav.setViewName("forward:/fileuploadresult.jsp");
			return mav;
		}
		
		
		
		
		return mav;
		
	}
	
	@ResponseBody
	@RequestMapping("/showmysources.do")
	public List<Source> showmysources(String target,HttpSession session)
	{
		Acount acount = (Acount)session.getAttribute("acount");
		System.out.println(acount);
		List<Source> list=null;
		
		if(acount == null || "".equals(acount.getAid().trim()))
		{
			return null;
		}
		if( "true".equals(target))
		{
			    list= this.ss.querySourceBySpublisher(acount.getAname());
		}
		return list;
	}
	
	
	@RequestMapping("/showsourcedetail.do")
	public ModelAndView showsourcedetail(String sid,HttpSession session)
	{
		Acount acount = (Acount)session.getAttribute("acount");
		ModelAndView mav = new ModelAndView();
		List<Source> list=null;
		if(acount == null || "".equals(acount.getAid().trim()) || sid == null)
		{
			return null;
		}
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("sid", sid);
		map.put("spublisher", acount.getAname());
		Source source = this.ss.querySourceBySidAndSpublisher(map);
		mav.addObject("source",source);
		mav.setViewName("forward:/needlogin/sourcedetail.jsp");
		System.out.println(source);
		
		
		return mav;
	}
	@RequestMapping("/searchdetail.do")
	public ModelAndView searchdetail(String sid,HttpSession session)
	{
		Acount acount = (Acount)session.getAttribute("acount");
		ModelAndView mav = new ModelAndView();
		List<Source> list=null;
		if(acount == null || "".equals(acount.getAid().trim()) || sid == null)
		{
			return null;
		}
		Source source = this.ss.querySourceBySid(sid);
		mav.addObject("source",source);
		mav.setViewName("forward:/needlogin/sourcedetail.jsp");
		System.out.println(source);
		
		
		return mav;
	}
	@ResponseBody
	@RequestMapping("/downloadtimesplus.do")
	public ResultMessage downloadtimesplus(String sid,HttpSession session)
	{
		Acount acount = (Acount)session.getAttribute("acount");
		ResultMessage rm = new ResultMessage("下载失败", -1, false);
		List<Source> list=null;
		if(acount == null || "".equals(acount.getAid().trim()) || sid == null)
		{
			return null;
		}
		Source s = this.ss.querySourceBySid(sid);
		if(s == null || "".equals(s.getSid()))
		{
			return rm;
		}
		s.setSdownloadtimes(s.getSdownloadtimes()+1);
		boolean result = this.ss.modifySource(s);
		if(result)
		{
			rm.setFlag(true);
			rm.setFlagnum(1);
			rm.setMessage("下载成功");
		}
		
		return rm;
	}
	
	
	@ResponseBody
	@RequestMapping("/deletesource.do")
	public ResultMessage deletesource(String sid,HttpSession session)
	{
		Acount acount = (Acount)session.getAttribute("acount");
		ResultMessage rm = new ResultMessage("删除失败", -1, false);
		if(acount == null || "".equals(acount.getAid().trim()) || sid == null)
		{
			return null;
		}
		boolean result = this.ss.removeSourceBySid(sid);
		if(result)
		{
			rm.setFlag(true);
			rm.setMessage("删除成功");
		}
		return rm;
	}
	
	//查找资源
	@ResponseBody
	@RequestMapping("/{pagenum}/searchsource.do")
	public List<Source> searchsource(String content,@PathVariable("pagenum") int pagenum,HttpSession session)
	{
		Acount acount = (Acount)session.getAttribute("acount");
		if(acount == null || "".equals(acount.getAid().trim()) || content == null)
		{
			return null;
		}
		
		//查出总条数
		int count = this.ss.queryCountLikeContent(content);
		int nextcount = 0;
		int n = 1;//最大页数
		if(pagenum <=0)
		{
			pagenum =1;
		}
		if(count == 0)
		{
			
		}
		else{
			//最大页数
			n = (count % 10) >0 ? (count / 10 + 1):(count / 10 );
			System.out.println("最大页数"+n);
			 nextcount =  pagenum*10;
			if(nextcount > count)
			{
				//到了最后一页
				nextcount = count;
			}
			
			}
		int begin = (pagenum-1)*10;
		int end = nextcount;
		
		Map<String, Object> map = new HashMap<>();
		map.put("content", content);
		map.put("begin", begin);
		map.put("end", end);
		
		List<Source> list = this.ss.querySourceByCondition(map);
		
		return list;
	}
}
