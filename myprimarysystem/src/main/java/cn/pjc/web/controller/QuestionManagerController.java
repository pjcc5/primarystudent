package cn.pjc.web.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.pjc.dto.ResultMessage;
import cn.pjc.pojo.Question;
import cn.pjc.service.QuestionService;
import cn.pjc.util.IDHelper;


@Controller
@RequestMapping("/question")
public class QuestionManagerController {
	@Autowired
	private QuestionService qs = null;
	
	@RequestMapping("/uploadsubject.do")
	@ResponseBody
	public ResultMessage uploadsubject(Question question){
		ResultMessage  rm = new ResultMessage("登记失败", -1, false);
		
		question.setQid(IDHelper.getUUID());
		question.setQchangetime(new Timestamp(new Date().getTime()));
		question.setQregisttime(new Timestamp(new Date().getTime()));
		//这里应该判断试题是否重复提交(同一个人,相同题干)
		
		//保存试题
		boolean result = this.qs.saveQuestion(question);
		if(result){
			rm.setFlag(true);
			rm.setMessage("登记成功");
		}
		return rm;
		
	}
	
	@RequestMapping("/{pagenum}/showmysubject.do")
	public ModelAndView showmysubject(String ccc,@PathVariable("pagenum") int pagenum){
		ModelAndView mav = new ModelAndView();
		
		if(ccc==null || "".equals(ccc))
		{
			mav.setViewName("redirect:/");//返回主页
			return mav;
		}
		
		//查询出此用户的所有题目
		int count = this.qs.queryCountByQaid(ccc);
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
		System.out.println("bengin:"+begin+"end"+end);
		//查询数据
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("qaid", ccc);
		map.put("begin", begin);
		map.put("end", end);
		List<Question> list = this.qs.queryQuestionByQaid(map);
		mav.addObject("maxpage", n);
		mav.addObject("subjects", list);
		mav.addObject("nextpage", pagenum);
		mav.setViewName("forward:/needlogin/showmysubject.jsp");
		return mav;
		
	}
}
