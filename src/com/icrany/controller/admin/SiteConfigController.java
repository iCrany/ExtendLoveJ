package com.icrany.controller.admin;

import java.util.Map;

import org.directwebremoting.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.icrany.view.Music;
import com.icrany.vo.SiteConfig;
import com.icrany.service.SiteConfigService;

@Controller
@RequestMapping(value="/jsp/admin/site")
public class SiteConfigController {

	private static final Logger logger = Logger.getLogger(SiteConfigController.class);
	
	@Autowired
	private SiteConfigService siteConfigService ;
	
	private static final String CONTROL_CONFIG = "config_control";

	private static final String UPDATE_CONFIG = "config_update";
	
	private static final String CONTROL_MUSIC = "music_control";
	
	@RequestMapping(value="/config_control",method=RequestMethod.GET)
	public String configControlMethodGet(Map<String,Object> map,SiteConfig siteConfig){
		siteConfig = siteConfigService.find(siteConfig);
		map.put("siteConfig", siteConfig);
		return CONTROL_CONFIG;
	}
	
	@RequestMapping(value="/config_update",method=RequestMethod.GET)
	public String updateMethodGet(Map<String,Object> map,SiteConfig siteConfig){
		logger.info("updateMethodGet()");
		siteConfig = siteConfigService.find(siteConfig);
		map.put("siteConfig", siteConfig);
		return CONTROL_CONFIG;
	}
	
	@RequestMapping(value="/config_update",method=RequestMethod.POST)
	public String updateMethodPost(Map<String,Object> map,SiteConfig siteConfig){
		logger.info("updateMethodPost()");

		SiteConfig entity = new SiteConfig();
		entity.setId(siteConfig.getId());
		entity = siteConfigService.find(entity);//先查找，有就更新，没有就插入
		if(null == entity)
			siteConfigService.insert(siteConfig);//插入
		else
			siteConfigService.update(siteConfig);//更新
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
