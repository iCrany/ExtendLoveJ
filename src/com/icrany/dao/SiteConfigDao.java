package com.icrany.dao;

import java.util.List;

import com.icrany.system.Constants;
import org.directwebremoting.util.Logger;
import org.kidding.orm.dao.imp.BaseDAO;
import org.springframework.stereotype.Repository;

import com.icrany.vo.SiteConfig;

@Repository
public class SiteConfigDao extends BaseDAO<SiteConfig> {
	
	private static final Logger logger = Logger.getLogger(SiteConfigDao.class);

	public SiteConfigDao() throws IllegalAccessException, InstantiationException {
		super(Constants.DB_ALIAS,SiteConfig.class);
	}
	
	/**
	 * 更新
	 * @param entity
	 * @return
	 */
	public Integer insert( SiteConfig entity){
		return this.save(entity);
	}

	/**
	 * 更新系统配置
	 * @param entity
	 * @return
	 */
	public Integer update( SiteConfig entity){
		try {
			return this._update(entity, false);
		}catch(Exception e){
			logger.error("更新系统配置失败！！！",e);
		}
		return -1;
	}
	
	/**
	 * 默认就只有一个 系统配置
	 * @param entity
	 * @return
	 */
	public SiteConfig find(SiteConfig entity){
		try {
			List<SiteConfig> siteConfigList = this.list(entity, null, null, null);

			if(null != siteConfigList && siteConfigList.size() != 0 ) return siteConfigList.get(0);
		}catch(Exception e){
			logger.error("查找系统配置出错！！！",e);
		}
		return null;
	}
	
	/**
	 * 获取所有的 siteConfig 的配置信息,这里默认的话就只有一个
	 * @return
	 */
	public SiteConfig findAllSiteConfig(){
		try {
			SiteConfig entity = new SiteConfig();
			List<SiteConfig> siteConfigList = this.list(entity,0,1,null,null,null);
			//TODO:get 方法默认采用 id 来进行查找，这里使用会报错
			if(null != siteConfigList && siteConfigList.size() != 0) return siteConfigList.get(0);
		}catch(Exception e){
			logger.error("获取所有的系统配置出错！！！",e);
		}
		return null;
	}
}
