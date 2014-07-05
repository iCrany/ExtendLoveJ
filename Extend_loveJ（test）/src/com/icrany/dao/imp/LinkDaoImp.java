package com.icrany.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.aspectj.apache.bcel.generic.GETSTATIC;
import org.directwebremoting.util.Logger;

import com.icrany.dao.LinkDao;
import com.icrany.dao.TagDao;
import com.icrany.pojo.Link;
import com.icrany.pojo.Tag;
import com.icrany.util.DbUtil;

public class LinkDaoImp implements LinkDao {
	
	private static final Logger logger = Logger.getLogger(TagDao.class);
	
	/**
	 * 添加新的链接
	 * @param entity
	 * @return
	 */
	public boolean insert(Link entity){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into link(name,description,trash,createTime,site,status) values(?,?,?,?,?,?)";
		
		conn = DbUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, entity.getName());
			pstmt.setString(2, entity.getDescription());
			pstmt.setBoolean(3, entity.isTrash());
			pstmt.setTimestamp(4, new Timestamp(entity.getCreateTime().getTime()));
			pstmt.setString(5, entity.getSite());
			pstmt.setString(6,entity.getStatus());
			
			if(pstmt.execute()){
				return true;
			}
		} catch (SQLException e) {
			logger.info("添加链接出错了" + e.getStackTrace());
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		
		return false;
	}
	
	/**
	 * 根据 id 来删除链接
	 * @param entity
	 * @return
	 */
	public boolean delete(Link entity){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "delete from link where id = ?";
		
		conn = DbUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, entity.getId());
			if(pstmt.execute()){
				return true;
			}
		} catch (SQLException e) {
			logger.error("删除链接出错了" + e.getStackTrace());
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		
		return false;
	}
	
	/**
	 * 根据 id 来查找链接
	 * @param id
	 * @return
	 */
	public Link findById(int id){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Link link = new Link();
		String sql = "select * from link where id = ?";
		
		conn = DbUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				link = fillLink(link,rs);
				return link;
			}
			
		} catch (SQLException e) {
			logger.error("根据 id 来查找链接出错了" + e.getStackTrace());
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}

		return null;
	}
	
	/**
	 * 查找所有的链接出来
	 * @return
	 */
	public List<Link> findAllLink(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Link> linkList = new ArrayList<Link>();
		
		String sql = "select * from link";
		
		conn = DbUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Link link = new Link();
				link = fillLink(link,rs);
				linkList.add(link);
			}
			return linkList;
			
		} catch (SQLException e) {
			logger.error("查找所有的链接出错了" + e.getStackTrace());
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		
		return null;
	}
	
	/**
	 * 查找最新添加的几个链接出来
	 * TODO:最好设置成可配置的
	 * @return
	 */
	public List<Link> findNewestLink(){
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Link> linkList = new ArrayList<Link>();
		
		String sql = "select * from link order by createTime desc";
		
		conn = DbUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Link link = new Link();
				link = fillLink(link,rs);
				linkList.add(link);
				
				if(linkList.size() >= 5) break;
			}
			return linkList;
			
		} catch (SQLException e) {
			logger.error("查找最新的链接出错了 " + e.getStackTrace());
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		
		return null;		
	}
	
	/**
	 * 更新链接
	 * @param entity
	 * @return
	 */
	public boolean update(Link entity){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "update link set name=?, description=?,trash=?,createTime=?,site=?,status=? where id=?";
		
		conn = DbUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, entity.getName());
			pstmt.setString(2, entity.getDescription());
			pstmt.setBoolean(3, entity.isTrash());
			pstmt.setTimestamp(4, new Timestamp(entity.getCreateTime().getTime()));
			pstmt.setString(5, entity.getSite());
			pstmt.setString(6, entity.getStatus());
			pstmt.setInt(7, entity.getId());
			
			System.out.println(" pstmt toString() = "+pstmt.toString());
			if(pstmt.executeUpdate()>0){
				System.out.println("true");
				return true;
			}
			
		} catch (SQLException e) {
			logger.error("更新链接出错了" + e.getStackTrace());
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
	public Link fillLink(Link entity, ResultSet rs){
		
		try {
			entity.setId(rs.getInt("id"));
			entity.setName(rs.getString("name"));
			entity.setDescription(rs.getString("description"));
			entity.setTrash(rs.getBoolean("trash"));
			entity.setCreateTime(rs.getTimestamp("createTime"));
			entity.setSite(rs.getString("site"));
			entity.setStatus(rs.getString("status"));
			return entity;
		} catch (SQLException e) {
			logger.error("填充链接实例出错了" + e.getStackTrace());
			e.printStackTrace();
		}
		
		return null;
	}
}
