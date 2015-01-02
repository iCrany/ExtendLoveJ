package com.icrany.dao;

import java.util.List;

import com.icrany.system.Constants;
import org.directwebremoting.util.Logger;
import org.kidding.orm.dao.imp.BaseDAO;
import org.springframework.stereotype.Repository;

import com.icrany.vo.Category;

@Repository
public class CategoryDao extends BaseDAO<Category>{
	
	private static final Logger logger = Logger.getLogger(CategoryDao.class);

	public CategoryDao() throws IllegalAccessException, InstantiationException {
		super(Constants.DB_ALIAS,Category.class);
	}
	
	/**
	 * 添加新的分类
	 * @param entity 实体对象
	 * @return 返回受影响的行数
	 */
	public Integer insert(Category entity){

		return this.save(entity);
	}
	
	/**
	 *
	 * @param entity 实体对象
	 * @return 返回受影响的行数
	 */
	public Integer delete(Category entity){
		try {
			System.out.println("id = " + entity.getId());
			return this._delete(entity, false);
		}catch(Exception e){
			logger.error("删除某个分类信息");
		}
		return -1;
	}
	
	/**
	 * 这里根据分类的 id 来查找相对应的分类
	 * @param id 分类 id
	 * @return 返回条件查询的分类对象
	 */
	public Category findById(Integer id){

		Category entity = new Category();
		entity.setId(id);
		return this.get(entity);
	}
	 
	
	/**
	 * 查找所有的 分类
	 * @return 返回符合条件的对象列表
	 */
	public List<Category> findAllCategory(){
		try {
			Category entity = new Category();
			return this.list(entity, null, null, null);
		}catch(Exception e){
			logger.error("查询所有分类出错！！！",e);
		}
		return null;
	}
	
	/**
	 * 更新分类
	 * @param entity 实体对象
	 * @return 返回受影响的行数
	 */
	public Integer update(Category entity){

		try {
			System.out.println("category name : " + entity.getName() + "  description : " + entity.getDescription());
			return this._update(entity, false);
		}catch(Exception e){
			logger.error("更新分类出错！！！",e);
		}
		return -1;
	}
}
