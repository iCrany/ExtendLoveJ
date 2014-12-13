package com.icrany.service;

import com.icrany.dao.SiteConfigDao;
import org.directwebremoting.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icrany.vo.SiteConfig;
@Service
public class SiteConfigService {

	private static final Logger logger = Logger.getLogger(SiteConfigService.class);
	
	@Autowired
	private SiteConfigDao siteConfigDao ;
	
	public Integer insert(SiteConfig entity) {
		return siteConfigDao.insert(entity);
	}

	public Integer update(SiteConfig entity) {
		return siteConfigDao.update(entity);
	}

	public SiteConfig find(SiteConfig entity) {
		return siteConfigDao.find(entity);
	}

	public SiteConfig findAllSiteConfig() {
		return siteConfigDao.findAllSiteConfig();
	}
}
