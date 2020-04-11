package cn.pjc.web.filter;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CharacterEncodingFilter implements Filter{

	private String oldEncoding = null;
	private String newEncoding = null;
	@Override
	public void destroy() {
		System.out.println("destroy");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		String method = request.getMethod();
		if("POST".equalsIgnoreCase(method)){
			request.setCharacterEncoding(newEncoding);
		}else{
			Map<String,String[]> maps = request.getParameterMap();
			Iterator<String[]> it = maps.values().iterator();
			while(it.hasNext()){
				String[] strs = it.next();
				for (int i = 0; i < strs.length; i++) {
					strs[i] = new String(strs[i].getBytes(oldEncoding),newEncoding);
				}
			}
		}
		response.setCharacterEncoding(newEncoding);
		arg2.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		oldEncoding = arg0.getInitParameter("oldEncoding");
		newEncoding = arg0.getInitParameter("newEncoding");
	}

}
