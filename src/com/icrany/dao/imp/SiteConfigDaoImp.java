package com.icrany.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.directwebremoting.util.Logger;
import org.springframework.stereotype.Repository;

import com.icrany.dao.SiteConfigDao;
import com.icrany.pojo.SiteConfig;
import com.icrany.util.DbUtil;

@Repository
public class SiteConfigDaoImp implements SiteConfigDao {
	
	private static final Logger logger = Logger.getLogger(SiteConfigDaoImp.class);
	
	/**
	 * 更新
	 * @param entity
	 * @return
	 */
	public boolean insert( SiteConfig entity){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into site_config(about,contactDescription,icp,name,url) values(?,?,?,?,?)";
		
		conn = DbUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, entity.getAbout());
			pstmt.setString(2, entity.getContactDescription());
			pstmt.setString(3, entity.getIcp());
			pstmt.setString(4, entity.getName());
			pstmt.setString(5, entity.getUrl());
			
			if(pstmt.execute()){
				return true;
			}
			
		} catch (SQLException e) {
			logger.error("更新系统配置出错了"+e.getStackTrace());
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}		
		
		return false;
	}	
	
	
	/**
	 * 更新系统配置
	 * @param entity
	 * @return
	 */
	public boolean update( SiteConfig entity){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "update site_config set name=?, contactDescription=?,about=?,icp=?, url=? where id=?";
		
		conn = DbUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, entity.getName());
			pstmt.setString(2, entity.getContactDescription());
			pstmt.setString(3, entity.getAbout());
			pstmt.setString(4, entity.getIcp());
			pstmt.setString(5, entity.getUrl());
			pstmt.setInt(6, entity.getId());
			
			if(pstmt.executeUpdate()>0){
				return true;
			}
			
		} catch (SQLException e) {
			logger.error("更新系统配置出错了"+e.getStackTrace());
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}		
		
		return false;
	}
	
	/**
	 * 默认就只有一个 系统配置
	 * @param siteConfig
	 * @return
	 */
	public SiteConfig find(SiteConfig entity){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from  site_config";
		
		conn = DbUtil.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				entity = fillSiteConfig(entity,rs);
				return entity;
			}
			
		} catch (SQLException e) {
			logger.error("更新系统配置出错了"+e.getStackTrace());
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}				
		return null;
	}
	
	/**
	 * 获取所有的 siteConfig 的配置信息,这里默认的话就只有一个
	 * @return
	 */
	public SiteConfig findAllSiteConfig(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SiteConfig entity = new SiteConfig();
		
		String sql = "select * from site_config";
		
		conn = DbUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				entity = fillSiteConfig(entity,rs);
			}
			
			return entity;
			
		} catch (SQLException e) {
			logger.error("获取所有siteConfig配置信息出错了"+e.getStackTrace());
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}				
		
		return null;
		
		
	}
	
	/**
	 * 填充系统配置实例
	 * @param tag
	 * @param rs
	 * @return
	 */
	public  SiteConfig fillSiteConfig( SiteConfig entity, ResultSet rs){
		
		try {
			entity.setId(rs.getInt("id"));
			entity.setName(rs.getString("name"));
			entity.setContactDescription(rs.getString("contactDescription"));
			entity.setIcp(rs.getString("icp"));
			entity.setName(rs.getString("name"));
			entity.setUrl(rs.getString("url"));
			entity.setAbout(rs.getString("about"));
			
			return entity;
		} catch (SQLException e) {
			logger.error("填充系统配置实例出错了"+e.getStackTrace());
			e.printStackTrace();
		}
		
		return null;
	}
}
