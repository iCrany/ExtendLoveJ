package com.icrany.controller.admin;

import java.util.Map;

import org.directwebremoting.util.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.icrany.pojo.Music;
import com.icrany.pojo.SiteConfig;
import com.icrany.service.SiteConfigService;
import com.icrany.service.imp.SiteConfigServiceImp;

@Controller
@RequestMapping(value="/jsp/admin/site")
public class SiteConfigController {

	private static final Logger logger = Logger.getLogger(SiteConfigController.class);
	
	private static SiteConfigService siteConfigService = new SiteConfigServiceImp(); 
	
	private static final String CONTROL_CONFIG = "config_control";
	
	private static final String CONTROL_MUSIC = "music_control";
	
	@RequestMapping(value="/config_control",method=RequestMethod.GET)
	public String configControlMethodGet(Map<String,Object> map,SiteConfig siteConfig){
		
		siteConfig = siteConfigService.find(siteConfig);
		map.put("siteConfig", siteConfig);
		return CONTROL_CONFIG;
	}
	
	@RequestMapping(value="/config_update",method=RequestMethod.POST)
	public String update(Map<String,Object> map,SiteConfig siteConfig){
		siteConfigService.update(siteConfig);//先更新
		siteConfig = siteConfigService.find(siteConfig);//在查找
		map.put("siteConfig", siteConfig);
		return CONTROL_CONFIG;
	}
	
	@RequestMapping(value="/config_update",method=RequestMethod.POST)
	public String configControlMethodPost(Map<String,Object> map,SiteConfig siteConfig){
		siteConfigService.update(siteConfig);//先更新
		siteConfig = siteConfigService.find(siteConfig);//在查找
		map.put("siteConfig", siteConfig);
		return CONTROL_CONFIG;
	}
	
	/**
	 * TODO:这里是一个问题，是从配置文件中读取还是从数据库中读取呢？
	 * @param map
	 * @param music
	 * @return
	 */
	@RequestMapping(value="/music_control")
	public String music(Map<String,Object> map,Music music){
		
		return CONTROL_MUSIC;
	}
	
} 
