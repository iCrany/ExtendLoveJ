package com.icrany.dao;

import java.util.List;

import com.icrany.pojo.SiteConfig;

public interface SiteConfigDao {
	public boolean insert( SiteConfig entity);
	public boolean update( SiteConfig entity);
	public SiteConfig find(SiteConfig entity);
	public SiteConfig findAllSiteConfig();
}
