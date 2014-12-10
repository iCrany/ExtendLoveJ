package com.icrany.dao.imp;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.directwebremoting.util.Logger;
import org.springframework.stereotype.Repository;

import com.icrany.dao.CommentDao;
import com.icrany.pojo.Comment;
import com.icrany.util.DbUtil;

@Repository
public class CommentDaoImp implements CommentDao {
	
	private static final Logger logger = Logger.getLogger(CommentDaoImp.class);
	private List<Comment> articleList;
	
	/**
	 * 添加新的标签
	 * @param entity
	 * @return
	 */
	public boolean insert(Comment entity){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into comment(articleId,content,email,name,postIP,postTime,site,status,trash) values(?,?,?,?,?,?,?,?,?)";
		
		conn = DbUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, entity.getArticleId());
			pstmt.setString(2, entity.getContent());
			pstmt.setString(3, entity.getEmail());
			pstmt.setString(4, entity.getName());
			pstmt.setString(5, entity.getPostIP());
			pstmt.setTimestamp(6, new Timestamp(entity.getPostTime().getTime()));
			pstmt.setString(7, entity.getSite());
			pstmt.setBoolean(8, entity.isStatus());
			pstmt.setBoolean(9, entity.isTrash());
			
			if(pstmt.execute()){
				return true;
			}
		} catch (SQLException e) {
			logger.info("添加评论出错了 " + e.getStackTrace());
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		
		return false;
	}
	
	/**
	 * 根据 id 来删除评论
	 * @param entity
	 * @return
	 */
	public boolean delete(Comment entity){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "delete from comment where id = ?";
		
		conn = DbUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, entity.getId());
			
			//TODO: 这些delete update 等更新的操作是不可以用 execute() 方法根据返回值来判断是否更新成功的
			if(pstmt.executeUpdate()>0){
				return true;
			}
		} catch (SQLException e) {
			logger.error("删除评论出错了" + e.getStackTrace());
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		
		return false;
	}
	
	/**
	 * 根据 id 来查找评论
	 * @param id
	 * @return
	 */
	public Comment findById(int id){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Comment comment = new Comment();
		String sql = "select * from comment where id = ?";
		
		conn = DbUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				comment = fillComment(comment,rs);
				return comment;
			}
			
		} catch (SQLException e) {
			logger.error("根据 id 来查找评论出错了" + e.getStackTrace());
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}

		return null;
	}
	
	/**
	 * 查找所有的评论出来
	 * @return
	 */
	public List<Comment> findAllComment(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Comment> commentList = new ArrayList<Comment>();
		
		String sql = "select * from comment";
		
		conn = DbUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Comment comment = new Comment();
				comment = fillComment(comment,rs);
				commentList.add(comment);
			}
			return commentList;
			
		} catch (SQLException e) {
			logger.error("查找所有的评论出错了" + e.getStackTrace());
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		
		return null;
	}
	
	
	/**
	 * 根据文章的id 来查询对应文章的评论数组
	 * @param articleId
	 * @return
	 */
	public List<Comment> findByArticleId(int articleId){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from comment where articleId = ?";
		List<Comment> commentList = new ArrayList<Comment>();
		
		conn = DbUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, articleId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Comment entity = new Comment();
				entity = fillComment(entity,rs);
				commentList.add(entity);
			}
			return commentList;
			
		} catch (SQLException e) {
			logger.error("获取文章对应的评论数组出错 "+e.getStackTrace());
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}		

		return null;		
	}	
	
	/**
	 * 查找出最新评论的几篇文章出来
	 * TODO:最好就是可以写成可配置的，让管理员自己配置最新显示多少
	 * @return
	 */
	public List<Comment> findNewestComment(){
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Comment> commentList = new ArrayList<Comment>();
		
		String sql = "select * from comment order by postTime desc";
		
		conn = DbUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Comment comment = new Comment();
				comment = fillComment(comment,rs);
				commentList.add(comment);
				if(commentList.size() >= 5) break;
			}
			
			return commentList;
			
		} catch (SQLException e) {
			logger.error("查找最新的评论出错了" + e.getStackTrace());
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		return null;		
	}	
	
	/**
	 * 更新评论
	 * @param entity
	 * @return
	 */
	public boolean update(Comment entity){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "update comment set articleId=?,content=?,name=?,postIP=?,site=?, status=?,trash=? where id=?";
		
		conn = DbUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,entity.getArticleId());
			pstmt.setString(2,entity.getContent());
			pstmt.setString(3, entity.getName());
			pstmt.setString(4,entity.getPostIP());
			pstmt.setString(5, entity.getSite());
			pstmt.setBoolean(6,entity.isStatus());
			pstmt.setBoolean(7,entity.isTrash());
			pstmt.setInt(8, entity.getId());
			
			if(pstmt.execute()){
				return true;
			}
			
		} catch (SQLException e) {
			logger.error("更新评论出错了" + e.getStackTrace());
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}		
		
		return false;
	}
	
	/**
	 * 根据 name 的参数来设置不同的属性，要设定的值就已经存放在了 entity 中的该属性中，然后只需要更新数据库中的值即可
	 * 这默认的是 如果属性值为 boolean 的话 那么 对应的get/set 方法为 isXXX() 和  setXXX() 
	 * @param name 
	 * @param entity
	 * @return
	 */
	public boolean updateAttribute(String name,Comment entity){
		logger.info("updateAttribute()");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String attributeName = null;
		String methodName = null;
		String fieldType = null;
		Object value = null;
		
		//这个 name 的值为该类的某一个属性
		String sql = "update comment set "+name+"=? where id=?";
		
		if(name==null || name.equals("")) return false;
		String firstChar = name.substring(0, 1);
		attributeName = name.replaceFirst(firstChar,firstChar.toUpperCase());
//		System.out.println("attributeName = "+attributeName);
		Class clazz = entity.getClass();//获取 entity 的类的类型
//		System.out.println(" clazz.name = "+clazz.getName());
//		if(clazz.isInstance(entity)) System.out.println("clazz 是同一个类的派生类");
		
		methodName = "is"+attributeName;
		conn = DbUtil.getConnection();
		
		try {
			
			try {
				
				Field filed = clazz.getDeclaredField(name);
				
				//TODO: 这里要学习 getField() 和 getDeclaredField() 的区别，以及底层的机制
//					Field field = clazz.getField(name);这个方法是只能够获取public 类型的属性的
				int mod = filed.getModifiers();
//				System.out.println(" filed type = "+filed.getType().getName());//取得类型名
				fieldType = filed.getType().getName();
				//这里设置默认的 get 方法，如果是 boolean 的话 ，默认为 isXXX()的方法
				if("boolean".equals(fieldType)){
					methodName = "is"+attributeName;
				}
				else{
					methodName = "get"+attributeName;
				}
				
			} catch (NoSuchFieldException e1) {
				e1.printStackTrace();
			}
			Method method1 = clazz.getDeclaredMethod(methodName);
			
			try {
				
//				System.out.println("method1 = "+method1.invoke(entity));
				value = method1.invoke(entity);//设置相对应的值
				//这里开始调用相应的 get 方法来获取相对应的值
				try {
					pstmt = conn.prepareStatement(sql);
					//这里开始设置 sql 的参数，注意！！！
					
					System.out.println(" in the DaoImp trash = " + value);
					if("boolean".equals(fieldType)){
						pstmt.setBoolean(1, (Boolean)value);
						
					}else if("String".equals(fieldType)){
						pstmt.setString(1, (String)value);
						
					}else if("int".equals(fieldType) || "Integer".equals(fieldType)){
						pstmt.setInt(1, (Integer)value);
					}
					pstmt.setInt(2, entity.getId());
					
					System.out.println("xxxxxxxxxxxxxxx pstmt toString = "+pstmt.toString());
					
					if(pstmt.executeUpdate()>0){
						return true;
					}
				
				} catch (SQLException e) {
					logger.info("updateAttribute() 类型的数据的 PreparedStatement 的set方法的类型出现了错误" + e.getStackTrace());
					e.printStackTrace();
				}
				
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}		
		
		return false;		
	}
	
	/**
	 * 根据 查询结果中的数据填充到 实例当中去
	 * @param entity
	 * @param rs
	 * @return
	 */
	public Comment fillComment(Comment entity, ResultSet rs){
		
		try {
			entity.setId(rs.getInt("id"));
			entity.setArticleId(rs.getInt("articleId"));
			entity.setContent(rs.getString("content"));
			entity.setEmail(rs.getString("email"));
			entity.setName(rs.getString("name"));
			entity.setPostIP(rs.getString("postIP"));
			entity.setSite(rs.getString("site"));
			entity.setStatus(rs.getBoolean("status"));
			entity.setTrash(rs.getBoolean("trash"));
			entity.setPostTime(rs.getTimestamp("postTime"));
			
			return entity;
		} catch (SQLException e) {
			logger.error("填充评论实例出错了" + e.getStackTrace());
			e.printStackTrace();
		}
		
		return null;
	}
	
	 
}
