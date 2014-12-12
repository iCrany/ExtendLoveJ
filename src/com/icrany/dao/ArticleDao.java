package com.icrany.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.icrany.system.Constants;
import org.apache.log4j.Logger;
import org.kidding.orm.dao.imp.BaseDAO;
import org.springframework.stereotype.Repository;

import com.icrany.vo.Article;
import com.icrany.util.DbUtil;

@Repository
public class ArticleDao extends BaseDAO<Article>{

	private final Logger logger = Logger.getLogger(this.getClass());

	public ArticleDao() throws IllegalAccessException, InstantiationException {
		super(Constants.DB_ALIAS,Article.class);
	}

	/**
	 * 保存创建的文章
	 * @param entity
	 * @return
	 */
	public Integer insert(Article entity){
		Integer count = null;
		try{
			 count = this.save(entity);
		}catch(Exception e){
			logger.error("fail to insert article!!!",e);
		}

		return count == null ? 0 : count.intValue();
	}

	public Integer deleteAllPage(){
		
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "delete from article  where articleType = 'page'";
		conn = DbUtil.getConnection();
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			if(pstmt.execute()){
				return 1;
			}
		} catch (SQLException e) {
			logger.error("删除所有的独立页面失败"+e.getStackTrace());
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}		
		return 0;
	}
	
	/**
	 * 根据文章的唯一标识符 id 来查询文章,成功返回 文章实体 否则返回 null
	 * @param id
	 * @return
	 */
	public Article findById(Integer id){
		Article entity = new Article();
		entity.setId(id);
		return this.get(entity);
	}
	
	/**
	 * 获取所有的文章,所有的 post 类型的文章
	 * @return
	 */
	public List<Article> findAllArticle(){
		try {
			List<Article> articleList;
			Article entity = new Article();
			entity.setArticleType("post");//筛选 post 的文章出来
			articleList = this.list(entity, null, "postTime desc", null);
			return articleList;
		}catch(Exception e){
			logger.error("查询所有的 post 类型的文章出错！！！",e);
		}
		return null;
	}
	
	/**
	 * 查找所有文章的 id 列表
	 * @return 查找失败返回 null
	 */
	public List<Article> findAllArticleId(){
		try {
			Article entity = new Article();
			entity.setArticleType("post");
			return this.list(entity, null, "postTime desc", null);
		}catch(Exception e){
			logger.error("查找所有文章 id 列表失败",e);
		}
		return null;
	}
	
	/**
	 * 这里是查找最新发布的新闻，这里默认是查找最新的五篇文章，或者不足五篇就直接少于五篇。
	 * TODO:这里最好改写为用户配置的显示
	 * @return
	 */
	public List<Article> findNewestArticle(){
		try {
			Article entity = new Article();
			entity.setArticleType("post");
			List<Article> result = this.list(entity, 0, 5, null, "postTime desc", null);
			return result;
		}catch(Exception e){
			logger.error("fail to get newest article!!!",e);
		}
		return null;
	}
	
	/**
	 * 寻找文章属性为 page 的文章,寻找所有的独立页面出来
	 * @return
	 */
	public List<Article> findPage(){
		try {
			Article entity = new Article();
			entity.setArticleType("page");
			return this.list(entity,null,null,null);
		}catch(Exception e){
			logger.error("fail to find all articleType = 'page' article!!!",e);
		}
		return null;
	}
	
	/**
	 * 寻找所有 文章属性为 nav_menu_item 的文章
	 * @return
	 */
	public List<Article> findNavMenuItem(){

		try{
			Article entity = new Article();
			entity.setArticleType("nav_menu_item");
			return this.list(entity,null,"menuOrder asc",null);
		}catch(Exception e){
			logger.error("寻找所有文章属性为 nav_menu_item 的文章失败！！！",e);
		}
		return null;
	}
	
	/**
	 * 模糊搜索
	 * @param key 关键字
	 * @return 匹配关键字的文章
	 */
	public List<Article> findByFuzzyName(String key){
		try {
			Article entity = new Article();
			entity.setArticleType("post");
			//TODO:like 语句 的编写
			return this.list(entity, "title LIKE '%" + key + "%'", null, null);
		}catch(Exception e){
			logger.error("关键字搜索失败！！！",e);
		}
		return null;
	}
}
