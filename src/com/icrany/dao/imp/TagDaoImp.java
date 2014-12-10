package com.icrany.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.directwebremoting.util.Logger;
import org.springframework.stereotype.Repository;

import com.icrany.dao.TagDao;
import com.icrany.pojo.Tag;
import com.icrany.util.DbUtil;

@Repository
public class TagDaoImp implements TagDao {
	
	private static final Logger logger = Logger.getLogger(TagDao.class);
	
	/**
	 * 添加新的标签
	 * @param entity
	 * @return
	 */
	public boolean insert(Tag entity){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into tag(name,description,trash) values(?,?,?)";
		
		conn = DbUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, entity.getName());
			pstmt.setString(2, entity.getDescription());
			pstmt.setBoolean(3, entity.isTrash());
			
			if(pstmt.execute()){
				return true;
			}
		} catch (SQLException e) {
			logger.info("添加标签出错了");
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		
		return false;
	}
	
	/**
	 * 根据 id 来删除标签
	 * @param entity
	 * @return
	 */
	public boolean delete(Tag entity){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "delete from tag where id = ?";
		
		conn = DbUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, entity.getId());
			if(pstmt.execute()){
				return true;
			}
		} catch (SQLException e) {
			logger.error("删除标签出错了");
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		
		return false;
	}
	
	/**
	 * 根据 id 来查找标签
	 * @param id
	 * @return
	 */
	public Tag findById(int id){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Tag tag = new Tag();
		String sql = "select * from tag where id = ?";
		
		conn = DbUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				tag = fillTag(tag,rs);
				return tag;
			}
			
		} catch (SQLException e) {
			logger.error("根据 id 来查找标签出错了");
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}

		return null;
	}
	
	/**
	 * 查找所有的标签出来
	 * @return
	 */
	public List<Tag> findAllTag(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Tag> tagList = new ArrayList<Tag>();
		
		String sql = "select * from tag";
		
		conn = DbUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Tag tag = new Tag();
				tag = fillTag(tag,rs);
				tagList.add(tag);
			}
			return tagList;
			
		} catch (SQLException e) {
			logger.error("查找所有的标签出错了");
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		
		return null;
	}
	
	/**
	 * 更新
	 * @param entity
	 * @return
	 */
	public boolean update(Tag entity){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "update tag set name=?, description=?,trash=? where id=?";
		
		conn = DbUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, entity.getName());
			pstmt.setString(2, entity.getDescription());
			pstmt.setBoolean(3, entity.isTrash());
			pstmt.setInt(4, entity.getId());
			
			if(pstmt.execute()){
				return true;
			}
			
		} catch (SQLException e) {
			logger.error("更新标签出错了");
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
	 * @param tag
	 * @param rs
	 * @return
	 */
	public Tag fillTag(Tag tag, ResultSet rs){
		
		try {
			tag.setId(rs.getInt("id"));
			tag.setName(rs.getString("name"));
			tag.setDescription(rs.getString("description"));
			tag.setTrash(rs.getBoolean("trash"));
			return tag;
		} catch (SQLException e) {
			logger.error("填充标签实例出错了");
			e.printStackTrace();
		}
		
		return null;
	}
}
