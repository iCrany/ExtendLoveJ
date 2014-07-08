package com.icrany.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

/**
 * 采用单例模式获取一个 Connection 实例
 * @author iCrany
 *
 */
public class DbUtil {
	
	private final static Logger logger = Logger.getLogger(DbUtil.class);
	
	private static Connection conn = null;
	
	/**
	 * 获取一个 Connection 实例
	 * @return
	 */
	public static Connection getConnection() {

		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			logger.error("数据库加载出错");
		}
		
		//TODO 记得修改密码！！！
		String url ="jdbc:mysql://localhost:3306/extendlovej?"+"user=root&password=root&useUnicode=true&characterEncoding=UTF-8";
		try {
			conn = DriverManager.getConnection(url);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("连接数据库出错");
		}
		return null;
	}
	
	/**
	 * 关闭一个Connection 实例
	 * @param conn
	 */
	public static void close(Connection conn){
		try {
			if(conn!=null && conn.isClosed()==false){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭一个 ResultSet 实例
	 * @param result
	 */
	public static void close(ResultSet result){
		if(result!=null){
			try {
				if(result.isClosed()==false){
					result.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 关闭一个Statement 实例
	 * @param stmt
	 */
	public static void close(Statement stmt){
		if(stmt!=null){
			try {
				if(stmt.isClosed()==false){
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 关闭一个 PreparedStatement 实例
	 * @param pstmt
	 */
	public static void close(PreparedStatement pstmt){
		if(pstmt!=null){
			try {
				if(pstmt.isClosed()==false){
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
