package com.icrany.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.directwebremoting.util.Logger;

import com.icrany.dao.CategoryArticleDao;
import com.icrany.dao.TagArticleDao;
import com.icrany.pojo.CategoryArticle;
import com.icrany.pojo.TagArticle;
import com.icrany.util.DbUtil;
import com.mysql.jdbc.Statement;

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

}
