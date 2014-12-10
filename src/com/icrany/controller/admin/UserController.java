package com.icrany.controller.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.directwebremoting.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.icrany.pojo.User;
import com.icrany.service.UserService;
import com.icrany.service.imp.UserServiceImp;

@Controller
@RequestMapping(value="/jsp/admin/user")
public class UserController {
	
	private static final Logger logger = Logger.getLogger(UserController.class);
	
	private static final String USER_UPDATEBASE = "user_updatebase";
	
	private static final String USER_UPDATEPASSWORD = "user_updatepassword";
	
	@Autowired
	private UserService userService ;

	/**
	 * 这个类是用来处理 类型之间的转换的问题，如 date --> String 之间的转换
	 * @param binder
	 */
	@InitBinder
	private void dateBinder(WebDataBinder binder) {
	            //The date format to parse or output your dates
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	            //Create a new CustomDateEditor
	    CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
	            //Register it as custom editor for the Date type
	    binder.registerCustomEditor(Date.class, editor);
	}
	
	@RequestMapping(value="/user_updatebase",method=RequestMethod.GET)
	public String updateBaseMethodGet(Map<String,Object> map,User user){
		
		user = userService.find(user);
		map.put("user", user);
		return USER_UPDATEBASE;
	}
	
	@RequestMapping(value="/user_updatebase",method=RequestMethod.POST)
	public String updateBaseMethodPost(Map<String,Object> map,User user){
		boolean statusCode = userService.updateBase(user);
		if(statusCode) map.put("message", "更新用户信息成功");
		else map.put("message", "更新用户信息失败");
		map.put("user", user);
		return USER_UPDATEBASE;
	}
	
	@RequestMapping(value="/user_updatepassword",method=RequestMethod.GET)
	public String updatePasswordMethodGet(Map<String,Object> map,User user){
		user = userService.find(user);
		map.put("user", user);
		return USER_UPDATEPASSWORD;
	}
	
	@RequestMapping(value="/user_updatepassword",method=RequestMethod.POST)
	public String updatePasswordMethodPost(Map<String,Object> map,User user){
		System.out.println(" user password = "+user.getPassword());
		boolean statusCode = userService.updatePassword(user);
		if(statusCode) map.put("message", "更新密码成功");
		else map.put("message", "更新密码失败");
		return USER_UPDATEPASSWORD;
	}
	
}
