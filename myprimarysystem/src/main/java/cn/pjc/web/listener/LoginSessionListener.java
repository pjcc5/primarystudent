package cn.pjc.web.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import cn.pjc.pojo.Acount;



public class LoginSessionListener implements HttpSessionAttributeListener{

	


	
		Map<String, HttpSession> map = new HashMap<String, HttpSession>();

		public void attributeAdded(HttpSessionBindingEvent event) {
			String name = event.getName();

			if (name.equals("acount")) {

				Acount personInfo = (Acount) event.getValue();

				if (map.get(personInfo.getAname()) != null) {
					HttpSession session = map.get(personInfo.getAname());
					Acount oldPersonInfo = (Acount) session.getAttribute("acount");
					session.removeAttribute("acount");
					session.setAttribute("msg", "您的帐号已经在其他机器上登录，您被迫下线。");
				}

				
				map.put(personInfo.getAname(), event.getSession());
				System.out.println(map.size());
			}
			
		}

		public void attributeRemoved(HttpSessionBindingEvent event) {

			String name = event.getName();

		
			if (name.equals("acount")) {
				
				Acount personInfo = (Acount) event.getValue();
				map.remove(personInfo.getAname());
				System.out.println("帐号" + personInfo.getAname() + "注销。");
			}
		}

		public void attributeReplaced(HttpSessionBindingEvent event) {

			String name = event.getName();

			
			if (name.equals("acount")) {

				
				Acount oldPersonInfo = (Acount) event.getValue();
				map.remove(oldPersonInfo.getAname());

			
				Acount personInfo = (Acount) event.getSession().getAttribute("acount");
				
			
				if (map.get(personInfo.getAname()) != null) {
					
					HttpSession session = map.get(personInfo.getAname());
					session.removeAttribute("acount");
					session.setAttribute("msg", "您的帐号已经在其他机器上登录，您被迫下线。");

				}
				map.put(personInfo.getAname(), event.getSession());
			}

		}


}
