package com.icrany.service.imp;

import org.directwebremoting.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.icrany.dao.SiteConfigDao;
import com.icrany.dao.imp.SiteConfigDaoImp;
import com.icrany.pojo.SiteConfig;
import com.icrany.service.SiteConfigService;

public class SiteConfigServiceImp implements SiteConfigService{

	private static final Logger logger = Logger.getLogger(SiteConfigServiceImp.class);
	
	@Autowired
	private static SiteConfigDao siteConfigDao = new SiteConfigDaoImp();
	
	@Override
	public boolean insert(SiteConfig entity) {
		return siteConfigDao.insert(entity);
	}

	@Override
	public boolean update(SiteConfig entity) {
		return siteConfigDao.update(entity);
	}

	@Override
	public SiteConfig find(SiteConfig entity) {
		return siteConfigDao.find(entity);
	}

	@Override
	public SiteConfig findAllSiteConfig() {
		return siteConfigDao.findAllSiteConfig();
	}
}
