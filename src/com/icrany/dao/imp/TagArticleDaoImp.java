package com.icrany.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.directwebremoting.util.Logger;
import org.springframework.stereotype.Repository;

import com.icrany.dao.TagArticleDao;
import com.icrany.pojo.TagArticle;
import com.icrany.util.DbUtil;
import com.mysql.jdbc.Statement;

@Repository
public class TagArticleDaoImp implements TagArticleDao {

	private static final Logger logger = Logger.getLogger(TagArticleDaoImp.class);
	
	/**
	 * 添加标签和文章的多对多的关联关系，成功的话返回 该 多对多关系的唯一标识符
	 * @param entity
	 * @return
	 */
	public int insert(TagArticle entity){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into tag_article(tagId,articleId) values(?,?)";
		
		conn = DbUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1,entity.getTagId());
			pstmt.setInt(2,entity.getArticleId());
			
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			
			if(rs!=null && rs.next()){
				return rs.getInt(1);
			}
			
		} catch (SQLException e) {
			logger.info("添加标签和文章的多对多关系出错了"+e.getStackTrace());
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		
		return -1;
	}
	
	/**
	 * 根据对应的文章 id 来获取相关的标签 id 
	 * @param articleId
	 * @return
	 */
	public List<Integer> queryByArticleId(int articleId){
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Integer> tagIdList = new ArrayList<Integer>();
		String sql = "select tagId from tag_article where articleId = ?";
		
		conn = DbUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,articleId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				int tagId = rs.getInt("tagId");
				tagIdList.add(tagId);
			}
			
			return tagIdList;
			
		} catch (SQLException e) {
			logger.info("查找文章对应的标签信息出错了" + e.getStackTrace());
			e.printStackTrace(); 
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		
		return null;			
	}

	/**
	 * 根据标签 id 来查找文章
	 * @param articleId
	 * @return
	 */
	public List<Integer> queryByTagId(int tagId){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Integer> articleIdList = new ArrayList<Integer>();
		String sql = "select articleId from tag_article where tagId = ?";
		
		conn = DbUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,tagId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				int articleId = rs.getInt("articleId");
				articleIdList.add(articleId);
			}
			
			return articleIdList;
			
		} catch (SQLException e) {
			logger.info("根据标签 id 来查找文章 id 出错了" + e.getStackTrace());
			e.printStackTrace(); 
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		
		return null;		
	}		
}
