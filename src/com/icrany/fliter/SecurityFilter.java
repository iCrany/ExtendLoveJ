package com.icrany.fliter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icrany.vo.User;


public class SecurityFilter implements Filter {

	public void destroy() {
		
	}
	
	/**
	 * 记录用户的登录信息，放在 session 中
	 */
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		User user = (User) request.getSession().getAttribute("user");
		
		if(null != user){
			chain.doFilter(servletRequest, servletResponse);
		}else
			response.sendRedirect(request.getContextPath()+"/register.jsp");
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}
