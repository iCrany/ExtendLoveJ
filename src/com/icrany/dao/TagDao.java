package com.icrany.dao;

import java.util.List;

import com.icrany.system.Constants;
import org.directwebremoting.util.Logger;
import org.kidding.orm.dao.imp.BaseDAO;
import org.springframework.stereotype.Repository;

import com.icrany.vo.Tag;

@Repository
public class TagDao  extends BaseDAO<Tag>{
	
	private static final Logger logger = Logger.getLogger(TagDao.class);

	public TagDao() throws IllegalAccessException, InstantiationException {
		super(Constants.DB_ALIAS,Tag.class);
	}
	
	/**
	 * 添加新的标签
	 * @param entity
	 * @return
	 */
	public Integer insert(Tag entity){
		return this.save(entity);
	}
	
	/**
	 * 根据 id 来删除标签
	 * @param entity
	 * @return
	 */
	public Integer delete(Tag entity){
		try {
			return this._delete(entity, false);
		}catch(Exception e){
			logger.error("删除标签出错！！！",e);
		}
		return -1;
	}
	
	/**
	 * 根据 id 来查找标签
	 * @param id
	 * @return
	 */
	public Tag findById(Integer id){
		Tag entity = new Tag();
		entity.setId(id);
		return this.get(entity);
	}
	
	/**
	 * 查找所有的标签出来
	 * @return
	 */
	public List<Tag> findAllTag(){
		try {
			Tag entity = new Tag();
			return this.list(entity, null, null, null);
		}catch(Exception e){
			logger.error("查找所有的标签出错！！！",e);
		}
		return null;
	}
	
	/**
	 * 更新
	 * @param entity
	 * @return
	 */
	public Integer update(Tag entity){
		try {
			return this._update(entity, false);
		}catch(Exception e){
			logger.error("更新标签出错！！！",e);
		}
		return -1;
	}
}
