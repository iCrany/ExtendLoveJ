package com.icrany.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.directwebremoting.util.Logger;

import com.icrany.dao.UserDao;
import com.icrany.pojo.User;
import com.icrany.util.DbUtil;

public class UserDaoImp implements UserDao {

	private static final Logger logger = Logger.getLogger(UserDaoImp.class);
	
	/**
	 * 添加新的标签
	 * @param entity
	 * @return
	 */
	public boolean insert(User entity){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into user(age,birthday,email,gender,nickname,password,qq,username,createTime,description,roleType) "
				+ " values(?,?,?,?,?,?,?,?,?,?,?)";
		
		conn = DbUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, entity.getId());
			pstmt.setTimestamp(2, new Timestamp(entity.getBirthday().getTime()));
			pstmt.setString(3, entity.getEmail());
			pstmt.setBoolean(4, entity.isGender());
			pstmt.setString(5, entity.getNickname());
			pstmt.setString(6, entity.getPassword());
			pstmt.setString(7,entity.getQq());
			pstmt.setString(8,entity.getUsername());
			pstmt.setTimestamp(9, new Timestamp(entity.getCreateTime().getTime()));
			pstmt.setString(10, entity.getDescription());
			pstmt.setInt(11,entity.getRoleType());
			
			if(pstmt.executeUpdate()>0){
				return true;
			}
		} catch (SQLException e) {
			logger.error("添加用户出错了"+ e.getStackTrace());
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		
		return false;
	}
	
	/**
	 * 根据 id 来删除用户
	 * @param entity
	 * @return
	 */
	public boolean delete(User entity){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "delete from user where id = ?";
		
		conn = DbUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, entity.getId());
			if(pstmt.execute()){
				return true;
			}
		} catch (SQLException e) {
			logger.error("删除用户出错了"+e.getStackTrace());
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		
		return false;
	}
	
	
	/**
	 * 更新用户信息
	 * @param entity
	 * @return
	 */
	public boolean updateBase(User entity){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "update user set nickname=?, description=?,age=?, birthday=?, gender=?, qq=? where id=?";
		
		conn = DbUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, entity.getNickname());
			pstmt.setString(2, entity.getDescription());
			pstmt.setInt(3, entity.getAge());
			pstmt.setTimestamp(4,new Timestamp(entity.getBirthday().getTime()));
			pstmt.setBoolean(5, entity.isGender());
			pstmt.setString(6,entity.getQq());
			pstmt.setInt(7, entity.getId());
			
			if(pstmt.executeUpdate()>0){
				return true;
			}
			
		} catch (SQLException e) {
			logger.error("更新用户出错了"+e.getStackTrace());
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}		
		
		return false;
	}
	
	/**
	 * 更新用户密码
	 * @param entity
	 * @return
	 */
	public boolean updatePassword(User entity){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "update user set password=? where id=?";
		
		conn = DbUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, entity.getPassword());
			pstmt.setInt(2, entity.getId());
			
			System.out.println(" pstmt toString = "+pstmt.toString());
			if(pstmt.executeUpdate()>0){
				return true;
			}
		} catch (SQLException e) {
			logger.error("更新用户密码出错 "+e.getStackTrace());
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * 检查用户的登录信息
	 * @param entity
	 * @return
	 */
	public User login(User entity){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from user where password=? and username=?";
		
		conn = DbUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, entity.getPassword());
			pstmt.setString(2,entity.getUsername());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				fillUser(entity,rs);
				return entity;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 查找出所有的用户
	 * @return
	 */
	public List<User> findAllUser(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<User> userList = new ArrayList<User>();
		
		String sql = "select * from user";
		
		conn = DbUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				User entity = new User();
				entity = fillUser(entity,rs);
				userList.add(entity);
			}
			
			return userList;
		} catch (SQLException e) {
			logger.error("查找所有用户出错 "+e.getMessage());
			e.printStackTrace();
		}
		return null;		
	}
	
	/**
	 * 需要注意的是这里默认是只有一位用户的就是管理员所以该方法和 findAllUser 方法没有区别
	 */
	public User find(User entity){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from user";
		
		conn = DbUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				entity = fillUser(entity,rs);
				return entity;
			}
			
			
		} catch (SQLException e) {
			logger.error("查找某个用户出错 "+e.getMessage());
			e.printStackTrace();
		}
		return null;			
	}
	
	
	/**
	 * 填充用户实体
	 * @param entity
	 * @param rs
	 * @return
	 */
	private User fillUser(User entity,ResultSet rs){
		
		try {
			entity.setUsername(rs.getString("username"));
			entity.setPassword(rs.getString("password"));
			entity.setBirthday(rs.getTimestamp("birthday"));
			entity.setCreateTime(rs.getTimestamp("createTime"));
			entity.setDescription(rs.getString("description"));
			entity.setEmail(rs.getString("email"));
			entity.setGender(rs.getBoolean("gender"));
			entity.setId(rs.getInt("id"));
			entity.setQq(rs.getString("qq"));
			entity.setRoleType(rs.getInt("roleType"));
			entity.setAge(rs.getInt("age"));
			entity.setNickname(rs.getString("nickName"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return entity;
	}
	
}
