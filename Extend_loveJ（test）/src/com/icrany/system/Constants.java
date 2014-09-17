package com.icrany.system;

/**
 * 一个系统的常量配置类，给定一些系统的配置变量名
 * @author <a href="http://www.icrany.com">iCrany</a>
 * 2014年9月3日 下午10:24:58
 */
public class Constants {

	public static final String LOGIN_USER = "user";
	
	public static final String COOKIE_IS_REMEMBER_USERNAME = "ExtendLoveJ.user.uername";
	
	public static final String COOKIE_IS_REMEMBER_PASSWORD = "ExtendLoveJ.user.password";
	
	/**cookies 的最大活跃周期，默认是为 一周 */
	public static final int COOKIE_IS_REMEMBER_MAX_ACTIVE_TIME = 7 * 24 * 60 * 60;
	
	
}
