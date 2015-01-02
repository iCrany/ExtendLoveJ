package com.icrany.dao;

import java.util.List;

import com.icrany.system.Constants;
import org.directwebremoting.util.Logger;
import org.kidding.orm.dao.imp.BaseDAO;
import org.springframework.stereotype.Repository;

import com.icrany.vo.CategoryArticle;

@Repository
public class CategoryArticleDao extends BaseDAO<CategoryArticle>{

	private static final Logger logger = Logger.getLogger(CategoryArticleDao.class);

	public CategoryArticleDao() throws IllegalAccessException, InstantiationException {
		super(Constants.DB_ALIAS,CategoryArticle.class);
	}
	
	/**
	 * 添加 分类和文章的多对多的关联关系，成功的话返回 该 多对多关系的唯一标识符
	 * @param entity
	 * @return
	 */
	public Integer insert(CategoryArticle entity){
		return this.save(entity);
	}
	
	/**
	 * 根据文章的 id 来查询出该文章对应的分类信息出来
	 * @param articleId
	 * @return
	 */
	public List<CategoryArticle> queryByArticleId(Integer articleId){
		try {
			CategoryArticle entity = new CategoryArticle();
			entity.setArticleId(articleId);

			return this.list(entity, null, null, null, "categoryId");
		}catch (Exception e){
			logger.error("查询文章分类 id 信息出错！！！",e);
		}
		return null;
	}
	
	/**
	 * 根据文章的 id 来查询出该文章对应的分类信息出来
	 * @param categoryId
	 * @return
	 */
	public List<CategoryArticle> queryByCategoryId(Integer categoryId){
		try {
			CategoryArticle entity = new CategoryArticle();
			entity.setCategoryId(categoryId);
			return this.list(entity, null, null, null, "articleId");
		}catch(Exception e){
			logger.error("查询文章 id 出错！！！",e);
		}
		return null;
	}

}
