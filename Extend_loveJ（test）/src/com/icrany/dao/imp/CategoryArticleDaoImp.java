package com.icrany.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.directwebremoting.util.Logger;

import com.icrany.dao.CategoryArticleDao;
import com.icrany.pojo.CategoryArticle;
import com.icrany.util.DbUtil;

public class CategoryArticleDaoImp implements CategoryArticleDao {

	private static final Logger logger = Logger.getLogger(CategoryArticleDao.class);
	
	/**
	 * 添加 分类和文章的多对多的关联关系，成功的话返回 该 多对多关系的唯一标识符
	 * @param entity
	 * @return
	 */
	public int insert(CategoryArticle entity){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into category_article(categoryId,articleId) values(?,?)";
		
		conn = DbUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1,entity.getCategoryId());
			pstmt.setInt(2,entity.getArticleId());
			
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			
			if(rs!=null && rs.next()){
				return rs.getInt(1);
			}
			
		} catch (SQLException e) {
			logger.info("添加文章与对应分类信息出错了"+e.getStackTrace());
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		
		return -1;
	}
	
	/**
	 * 根据文章的 id 来查询出该文章对应的分类信息出来
	 * @param articleId
	 * @return
	 */
	public List<Integer> queryByArticleId(int articleId){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Integer> categoryIdList = new ArrayList<Integer>();
		String sql = "select categoryId from category_article where articleId = ?";
		
		conn = DbUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,articleId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				int categoryId = rs.getInt("categoryId");
				categoryIdList.add(categoryId);
			}
			
			return categoryIdList;
			
		} catch (SQLException e) {
			logger.info("查找文章对应的分类信息出错了" + e.getStackTrace());
			e.printStackTrace(); 
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		
		return null;		
	}
	
	/**
	 * 根据文章的 id 来查询出该文章对应的分类信息出来
	 * @param articleId
	 * @return
	 */
	public List<Integer> queryByCategoryId(int categoryId){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Integer> articleIdList = new ArrayList<Integer>();
		String sql = "select articleId from category_article where categoryId = ?";
		
		conn = DbUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,categoryId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				int articleId = rs.getInt("articleId");
				articleIdList.add(articleId);
			}
			
			return articleIdList;
			
		} catch (SQLException e) {
			logger.info("查找文章对应的分类信息出错了" + e.getStackTrace());
			e.printStackTrace(); 
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		
		return null;		
	}	

}
