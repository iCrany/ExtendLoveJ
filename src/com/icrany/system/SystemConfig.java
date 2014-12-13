package com.icrany.system;

import java.util.HashMap;
import java.util.Map;

import com.icrany.vo.SiteConfig;
/**
 * 系统配置类
 * @author Administrator
 *
 */
public class SystemConfig {


	/**
	 * 站点的一些相关的信息，例如 站点的备案以及站点的一些描述
	 */
	private static SiteConfig siteConfig = null;
	
	/**
	 * 系统的一些配置信息，全部从 ExtendLoveJ.properties 文件中获取
	 */
	private static Map<String,String> systemConfig = new HashMap<String,String>();
	
	/**
	 * 上传文件的一些限制信息，规定上传的文件的一些类型
	 */
	private static Map<String,String> accessExtendType = new HashMap<String,String>();
	
	
	private static String  fileStorePlace = null;
	
	static{
		
		
	}
	
	private SystemConfig(){
		
	}
	
	public static SiteConfig getSiteConfig(){
		return SystemConfig.siteConfig;
	}
	
	public static void setSiteConfig(SiteConfig siteConfig){
		SystemConfig.siteConfig = siteConfig;
	}
	
	public static Map<String,String> getSystemConfig(){
		return SystemConfig.systemConfig;
	}
	
	public static Map<String,String> getAccessExtendType(){
		return SystemConfig.accessExtendType;
	}
	
	public static String getFileStorePlace() {
		return fileStorePlace;
	}

	public static void setFileStorePlace(String fileStorePlace) {
		SystemConfig.fileStorePlace = fileStorePlace;
	}	
}
