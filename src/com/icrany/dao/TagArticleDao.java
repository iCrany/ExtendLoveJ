package com.icrany.dao;

import java.util.List;

import com.icrany.system.Constants;
import org.directwebremoting.util.Logger;
import org.kidding.orm.dao.imp.BaseDAO;
import org.springframework.stereotype.Repository;

import com.icrany.vo.TagArticle;

@Repository
public class TagArticleDao extends BaseDAO<TagArticle>{

	private static final Logger logger = Logger.getLogger(TagArticleDao.class);

	private TagArticleDao() throws IllegalAccessException, InstantiationException {
		super(Constants.DB_ALIAS,TagArticle.class);
	}
	
	/**
	 * 添加标签和文章的多对多的关联关系，成功的话返回 该 多对多关系的唯一标识符
	 * @param entity
	 * @return
	 */
	public Integer insert(TagArticle entity){
		return this.save(entity);
	}
	
	/**
	 * 根据对应的文章 id 来获取相关的标签 id 
	 * @param articleId
	 * @return
	 */
	public List<TagArticle> queryByArticleId(Integer articleId){
		try {
			TagArticle entity = new TagArticle();
			entity.setArticleId(articleId);
			return this.list(entity, null, null, null,"tagId");
		}catch(Exception e){
			logger.error("根据文章 id 来查找 tag id 列表出错！！！",e);
		}
		return null;
	}

	/**
	 * 根据标签 id 来查找文章
	 * @param tagId
	 * @return
	 */
	public List<TagArticle> queryByTagId(Integer tagId){
		try {
			TagArticle entity = new TagArticle();
			entity.setTagId(tagId);
			return this.list(entity, null, null, null, "articleId");
		}catch(Exception e){
			logger.error("根据 tag id 来查询文章出错！！！",e);
		}
		return null;
	}
}
