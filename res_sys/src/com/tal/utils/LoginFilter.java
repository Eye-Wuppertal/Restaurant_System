package com.tal.utils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//���������ѵ�¼�Ŀ��Է��У�δ��¼��ת������¼ҳ��
public class LoginFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		Object obj = req.getSession().getAttribute( Constract.CURRENT_USER );
		if( obj == null ){
			//δ��¼����ת������¼ҳ��
			res.sendRedirect( req.getServletContext().getContextPath() + "/goLogin");
		}else{
			chain.doFilter(request, response);
		}
		
	}

}
