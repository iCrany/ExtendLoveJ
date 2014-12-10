package com.icrany.controller.admin;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.directwebremoting.util.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.icrany.pojo.User;
import com.icrany.system.Constants;

/**
 * 一个控制后台登录的控制器
 * @author <a href="http://www.icrany.com">iCrany</a>
 * 2014年9月2日 下午10:38:48
 */
@Controller
@RequestMapping("/jsp")
public class LoginController {
	
	public static Logger logger = Logger.getLogger(LoginController.class);
	
	/** 如果这里没有加 /的话，多了一层 jsp 的路径出来*/
	public static final String LOGIN = "login";
	
	public static final String LOGIN_SUCCESS = "admin/index";
	
	public static final String LOGIN_FAIL = "/jsp/login";
	
	public static final String LOGOUT = "/jsp/login";
	
	/**
	 * @param request
	 * @param response
	 * @param isRemember
	 * @return
	 */
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login() {
		System.out.println("login method get...");
		return LOGIN;
	}
	
	/**
	 * 处理登录的监听操作，进行登录信息的检验
	 * fix bug: 参数绑定出错， 之前有一个 Boolean isRemember 的参数，加上就会报 The request sent by the client was syntactically incorrect.
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String login(HttpServletRequest request,HttpServletResponse response, User user){
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String isRemember = request.getParameter("isRemember");
		
		if(isRemember != null) { //记住登录信息
			Cookie cookie = new Cookie(Constants.COOKIE_IS_REMEMBER_USERNAME,user.getUsername());
			cookie.setMaxAge(Constants.COOKIE_IS_REMEMBER_MAX_ACTIVE_TIME);
			response.addCookie(cookie);
			
			
			cookie = new Cookie(Constants.COOKIE_IS_REMEMBER_PASSWORD,user.getPassword());
			cookie.setMaxAge(Constants.COOKIE_IS_REMEMBER_MAX_ACTIVE_TIME);
			response.addCookie(cookie);
		}
		return LOGIN_SUCCESS;//登录成功的页面
	}	
	
	/**
	 * 直接进行登出的操作，并且查看是否需要将 cookies 的 记录我的记录删除
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request,HttpServletResponse response){
		
		return LOGOUT;
	}	
	
	
}
