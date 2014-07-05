package com.icrany.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.directwebremoting.util.Logger;

import com.icrany.dao.CategoryDao;
import com.icrany.pojo.Category;
import com.icrany.util.DbUtil;

public class CategoryDaoImp implements CategoryDao{
	
	private static final Logger logger = Logger.getLogger(CategoryDaoImp.class); 
	
	/**
	 * 添加新的分类
	 * @param entity
	 * @return
	 */
	public boolean insert(Category entity){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into category (parentId,createTime,description,name,priority,trash,type) values(?,?,?,?,?,?,?)";
		
		conn = DbUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,entity.getParentId());//根分类的祖先默认为 0 
			pstmt.setTimestamp(2, new Timestamp(entity.getCreateTime().getTime()));
			pstmt.setString(3, entity.getDescription());
			pstmt.setString(4,entity.getName());
			pstmt.setInt(5, entity.getPriority());
			pstmt.setBoolean(6, entity.isTrash());
			pstmt.setString(7,entity.getType());
			
			System.out.println("pstmt toString() = "+pstmt.toString());
			if(pstmt.executeUpdate()>0){
				return true;
			}
		} catch (SQLException e) {
			logger.error("添加新的分类出错了");
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
			
		}
		
		return false;
	}
	
	/**
	 * TODO:根据文章的 id 来删除文章，这里要记得还要删除相应的 附件信息 标签 等相关联的信息，这里还需要完善
	 * @param entity
	 * @return
	 */
	public boolean delete(Category entity){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "delete from category where id = ?";
		
		conn = DbUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, entity.getId());
			if(pstmt.execute()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);			
		}
		return false;
	}
	
	/**
	 * 这里根据分类的 id 来查找相对应的分类
	 * @param id
	 * @return
	 */
	public Category findById(int id){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Category entity = new Category();
		
		String sql = "select * from category where id = ?";
		
		conn = DbUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				entity = fillCategory(entity, rs);
				return entity;
			}
		} catch (SQLException e) {
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);			
		}
		return null;
	}
	 
	
	/**
	 * 查找所有的 分类
	 * @return
	 */
	public List<Category> findAllCategory(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from category";
		List<Category> categoryList = new ArrayList<Category>();
		
		conn = DbUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Category entity = new Category();
				
				entity = fillCategory(entity, rs);
				categoryList.add(entity);
			}
			
			return categoryList;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);				
		}
		
		return null;
	}
	
	/**
	 * 更新分类
	 * @param entity
	 * @return
	 */
	public boolean update(Category entity){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "update category set parentId=?, createTime=?,description=?,name=?,priority=?,trash=?, type=? where id=?";
		
		conn = DbUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,entity.getParentId());
			pstmt.setTimestamp(2, new Timestamp(entity.getCreateTime().getTime()));
			pstmt.setString(3,entity.getDescription());
			pstmt.setString(4,entity.getName());
			pstmt.setInt(5, entity.getPriority());
			pstmt.setBoolean(6, entity.isTrash());
			pstmt.setString(7, entity.getType());
			pstmt.setInt(8, entity.getId());
			
			System.out.println(" pstmt to String = "+pstmt.toString());
			if(pstmt.execute()) return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
				 
		return false;
	}
	
	/**
	 * 用来填充 实体的属性
	 * @param entity
	 * @param rs
	 * @return
	 */
	public Category fillCategory(Category entity,ResultSet rs){
		
		try {
			entity.setName(rs.getString("name"));
			entity.setCreateTime(rs.getTimestamp("createTime"));
			entity.setDescription(rs.getString("description"));
			entity.setParentId(rs.getInt("parentId"));
			entity.setPriority(rs.getInt("priority"));
			entity.setType(rs.getString("type"));
			entity.setId(rs.getInt("id"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return entity;
	}
}
