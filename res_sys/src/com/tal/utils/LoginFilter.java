package com.tal.utils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//过滤请求，已登录的可以放行，未登录的转跳到登录页面
public class LoginFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		Object obj = req.getSession().getAttribute( Constract.CURRENT_USER );
		if( obj == null ){
			//未登录，则转跳到登录页面
			res.sendRedirect( req.getServletContext().getContextPath() + "/goLogin");
		}else{
			chain.doFilter(request, response);
		}
		
	}

}
