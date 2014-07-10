package com.icrany.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.icrany.dao.ArticleDao;
import com.icrany.pojo.Article;
import com.icrany.util.DbUtil;
import com.mysql.jdbc.Statement;

public class ArticleDaoImp implements ArticleDao{

	private final Logger logger = Logger.getLogger(this.getClass());

	/**
	 * 保存创建的文章
	 * @param entity
	 * @return
	 */
	public int insert(Article entity){
		
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "insert into article (content,postTime,quote,status,summary,title,view,trash,topTime) "
				+ "values(?,?,?,?,?,?,?,?,?)";
		conn = DbUtil.getConnection();
		
		try {
			
			pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, entity.getContent());
			pstmt.setTimestamp(2, new Timestamp(entity.getPostTime().getTime()));
			pstmt.setString(3,entity.getQuote());
			pstmt.setString(4,entity.getStatus());
			pstmt.setString(5, entity.getSummary());
			pstmt.setString(6,entity.getTitle());
			pstmt.setInt(7, entity.getView());
			pstmt.setBoolean(8, entity.isTrash());
			pstmt.setTimestamp(9,  new Timestamp(entity.getTopTime().getTime()));
			
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			
			if(rs != null && rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			logger.error("保存文章失败"+e.getStackTrace());
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		
		return -1;
	}

	/**
	 * 更新文章的相关内容
	 * @param entity
	 * @return
	 */
	public boolean update(Article entity){
		
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "update article set content=?,postTime=?,quote=?,status=?,summary=?,title=?,view=?,trash=?,topTime=?,modifyTime=? where id=?";
		conn = DbUtil.getConnection();
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, entity.getContent());
			pstmt.setTimestamp(2, new Timestamp(entity.getPostTime().getTime()));
			pstmt.setString(3,entity.getQuote());
			pstmt.setString(4,entity.getStatus());
			pstmt.setString(5, entity.getSummary());
			pstmt.setString(6,entity.getTitle());
			pstmt.setInt(7, entity.getView());
			pstmt.setBoolean(8, entity.isTrash());
			pstmt.setTimestamp(9, new Timestamp(entity.getTopTime().getTime()));
			pstmt.setTimestamp(10, new Timestamp(entity.getModifyTime().getTime()));
			pstmt.setInt(11,entity.getId());
			
			System.out.println(" pstmt toStirng = "+pstmt.toString());
			if(pstmt.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			logger.error("更新文章失败"+e.getStackTrace());
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		
		return false;
	}
	
	/**
	 * 这里用来删除文章的，删除成功返回 true ， 否则返回 false
	 * @param entity
	 * @return
	 */
	public boolean delete(Article entity){
		
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "delete from article  where id=?";
		conn = DbUtil.getConnection();
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,entity.getId());
			
			if(pstmt.execute()){
				return true;
			}
		} catch (SQLException e) {
			logger.error("删除文章失败"+e.getStackTrace());
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}		
		return false;
	}
	
	/**
	 * 根据文章的唯一标识符 id 来查询文章,成功返回 文章实体 否则返回 null
	 * @param id
	 * @return
	 */
	public Article findById(int id){

		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "select * from article where id = ?";
		Article entity = new Article();
		
		conn = DbUtil.getConnection();
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();
			if(rs.next()){
				
				entity = fillArticle(entity,rs);
				
				return entity;
			}
		} catch (SQLException e) {
			logger.error("根据文章的唯一标识符来查询文章失败 "+e.getStackTrace());
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}		

		return null;
	}
	
	/**
	 * 获取所有的文章
	 * @return
	 */
	public List<Article> findAllArticle(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from article order by postTime desc";//根据发表的日期来排序显示
		List<Article> articleList = new ArrayList<Article>();
		
		conn = DbUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Article entity = new Article();
				entity = fillArticle(entity,rs);
				articleList.add(entity);
			}
			return articleList;
		} catch (SQLException e) {
			logger.error("获取所有文章出错 "+e.getStackTrace());
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}		

		return null;
	}
	
	/**
	 * 查找所有文章的 id 列表
	 * @return
	 */
	public List<Integer> findAllArticleId(){
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select id from article order by postTime desc";//根据发表的日期来排序显示
		List<Integer> articleIdList = new ArrayList<Integer>();
		
		conn = DbUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				int id = rs.getInt("id");
				articleIdList.add(id);
			}
			
			return articleIdList;
			
		} catch (SQLException e) {
			logger.error("查找所有文章的 id 列表出错 "+e.getStackTrace());
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}		

		return null;		
	}
	
	/**
	 * 这里是查找最新发布的新闻，这里默认是查找最新的五篇文章，或者不足五篇就直接少于五篇。
	 * TODO:这里最好改写为用户配置的显示
	 * @return
	 */
	public List<Article> findNewestArticle(){
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from article order by postTime desc";
		List<Article> articleList = new ArrayList<Article>();
		
		conn = DbUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Article entity = new Article();
				entity = fillArticle(entity,rs);
				articleList.add(entity);
				
				if(articleList.size() >= 5) break;//默认是取五篇文章的说,或者少于五篇
			}
			return articleList;
		} catch (SQLException e) {
			logger.error("获取最新发表的文章出错 " + e.getStackTrace());
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}		

		return null;
	}
	
	/**
	 * TODO：这里根据关键字来进行搜索，目前暂时只支持单个关键字搜索，而且是只能根据文章的标题来进行正则表达式的匹配，需要改进
	 * @param key
	 * @return
	 */
	public List<Article> findByFuzzyName(String key){
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from article where title LIKE ?";
		List<Article> articleList = new ArrayList<Article>();
		
		conn = DbUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + key + "%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Article entity = new Article();
				entity = fillArticle(entity,rs);
				articleList.add(entity);
			}
			
			return articleList;
		} catch (SQLException e) {
			logger.error("获取搜索关键字的文章出错 " + e.getStackTrace());
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}		
		return null;		
	}

	/**
	 * 用来填充文章实例用的方法
	 * @param entity
	 * @param rs
	 * @return
	 */
	
	public Article fillArticle(Article entity,ResultSet rs){
		
		try {
			entity.setTitle(rs.getString("title"));
			entity.setContent(rs.getString("content"));
			entity.setId(rs.getInt("id"));
			entity.setModifyTime(rs.getTimestamp("modifyTime"));
			entity.setPostTime(rs.getTimestamp("postTime"));
			entity.setQuote(rs.getString("quote"));
			entity.setStatus(rs.getString("status"));
			entity.setSummary(rs.getString("summary"));
			entity.setTopTime(rs.getTimestamp("topTime"));
			entity.setView(rs.getInt("view"));
			entity.setTrash(rs.getBoolean("trash"));
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return entity;
	}
}
