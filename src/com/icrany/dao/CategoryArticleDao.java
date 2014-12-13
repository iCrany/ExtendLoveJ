package com.icrany.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.icrany.system.Constants;
import org.directwebremoting.util.Logger;
import org.kidding.orm.dao.imp.BaseDAO;
import org.springframework.stereotype.Repository;

import com.icrany.vo.CategoryArticle;
import com.icrany.util.DbUtil;

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
//
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		String sql = "insert into category_article(categoryId,articleId) values(?,?)";
//
//		conn = DbUtil.getConnection();
//
//		try {
//			pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
//			pstmt.setInt(1,entity.getCategoryId());
//			pstmt.setInt(2,entity.getArticleId());
//
//			pstmt.executeUpdate();
//			rs = pstmt.getGeneratedKeys();
//
//			if(rs!=null && rs.next()){
//				return rs.getInt(1);
//			}
//
//		} catch (SQLException e) {
//			logger.info("添加文章与对应分类信息出错了"+e.getStackTrace());
//			e.printStackTrace();
//		}finally{
//			DbUtil.close(rs);
//			DbUtil.close(pstmt);
//			DbUtil.close(conn);
//		}
//
//		return -1;
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
//
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		List<Integer> categoryIdList = new ArrayList<Integer>();
//		String sql = "select categoryId from category_article where articleId = ?";
//
//		conn = DbUtil.getConnection();
//
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1,articleId);
//
//			rs = pstmt.executeQuery();
//
//			while(rs.next()){
//				int categoryId = rs.getInt("categoryId");
//				categoryIdList.add(categoryId);
//			}
//
//			return categoryIdList;
//
//		} catch (SQLException e) {
//			logger.info("查找文章对应的分类信息出错了" + e.getStackTrace());
//			e.printStackTrace();
//		}finally{
//			DbUtil.close(rs);
//			DbUtil.close(pstmt);
//			DbUtil.close(conn);
//		}
//
//		return null;
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
//
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		List<Integer> articleIdList = new ArrayList<Integer>();
//		String sql = "select articleId from category_article where categoryId = ?";
//
//		conn = DbUtil.getConnection();
//
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1,categoryId);
//
//			rs = pstmt.executeQuery();
//
//			while(rs.next()){
//				int articleId = rs.getInt("articleId");
//				articleIdList.add(articleId);
//			}
//
//			return articleIdList;
//
//		} catch (SQLException e) {
//			logger.info("查找文章对应的分类信息出错了" + e.getStackTrace());
//			e.printStackTrace();
//		}finally{
//			DbUtil.close(rs);
//			DbUtil.close(pstmt);
//			DbUtil.close(conn);
//		}
//
//		return null;
	}	

}
