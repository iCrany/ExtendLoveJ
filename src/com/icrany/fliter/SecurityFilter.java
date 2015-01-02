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

import com.icrany.dao.UserDao;
import com.icrany.vo.User;
import org.apache.log4j.Logger;

public class SecurityFilter implements Filter {

	private static Logger logger = Logger.getLogger(SecurityFilter.class);

	private static UserDao userDao;

	public void destroy() {
	}
	
	/**
	 * 记录用户的登录信息，放在 session 中
	 */
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {

		try {
			HttpServletRequest request = (HttpServletRequest) servletRequest;
			HttpServletResponse response = (HttpServletResponse) servletResponse;
			User user = (User) request.getSession().getAttribute("user");
			userDao = new UserDao();

			if (null != user) {
				//这里进行用户登录的检测
				if (null != userDao.login(user))
					chain.doFilter(servletRequest, servletResponse);//密码正确
				else
					response.sendRedirect(request.getContextPath() + "/register.jsp");
			} else {
				response.sendRedirect(request.getContextPath() + "/register.jsp");
			}
		}catch (Exception e){
			logger.error("fail to identify user",e);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}
