package com.icrany.dao;
import java.util.List;

import com.icrany.system.Constants;
import org.directwebremoting.util.Logger;
import org.kidding.orm.dao.imp.BaseDAO;
import org.springframework.stereotype.Repository;

import com.icrany.vo.Link;

@Repository
public class LinkDao extends BaseDAO<Link>{
	
	private static final Logger logger = Logger.getLogger(TagDao.class);

	public LinkDao() throws IllegalAccessException, InstantiationException {
		super(Constants.DB_ALIAS,Link.class);
	}
	
	/**
	 * 添加新的链接
	 * @param entity
	 * @return
	 */
	public Integer insert(Link entity){
		return this.save(entity);
	}
	
	/**
	 * 根据 id 来删除链接
	 * @param entity
	 * @return
	 */
	public Integer delete(Link entity){
		try {
			return this._delete(entity, false);
		}catch(Exception e){
			logger.error("删除连接失败！！！",e);
		}
		return -1;
	}
	
	/**
	 * 根据 id 来查找链接
	 * @param id
	 * @return
	 */
	public Link findById(Integer id){
		Link entity = new Link();
		entity.setId(id);
		return this.get(entity);
	}
	
	/**
	 * 查找所有的链接出来
	 * @return
	 */
	public List<Link> findAllLink(){
		try {
			Link entity = new Link();
			return this.list(entity, null, null, null);
		}catch(Exception e){
			logger.error("查找所有的链接出错！！！",e);
		}
		return null;
	}
	
	/**
	 * 查找最新添加的几个链接出来
	 * TODO:最好设置成可配置的
	 * @return
	 */
	public List<Link> findNewestLink(){
		try {
			Link entity = new Link();
			return this.list(entity, null, "createTime desc", null);
		}catch(Exception e){
			logger.error("查找最新的5个链接出错！！！",e);
		}
		return null;
	}
	
	/**
	 * 更新链接
	 * @param entity
	 * @return
	 */
	public Integer update(Link entity){
		try {
			return this._update(entity, false);
		}catch(Exception e){
			logger.error("更新链接出错！！！",e);
		}
		return -1;
	}
}
