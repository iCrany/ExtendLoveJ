package com.icrany.service;

import java.util.List;

import com.icrany.pojo.SiteConfig;

public interface SiteConfigService {
	public boolean insert( SiteConfig entity);
	public boolean update( SiteConfig entity);
	public SiteConfig find(SiteConfig entity);
	public SiteConfig findAllSiteConfig();
}
