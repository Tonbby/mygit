package com.tonbby.utils;

import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
public class DataSourceUtils1 {

	/**
	 * import java.sql.Connection;   
	 *  如果写成这个 com.mysql.jdbc.Connection
	 *  将会com.mchange.v2.c3p0.impl.NewProxyConnection cannot be
	 *   cast to com.mysql.jdbc.Connection
 
	 * */
	private static ComboPooledDataSource ds = new ComboPooledDataSource();
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	
	public static Connection getConnection() throws SQLException{
		Connection conn = tl.get();
		if(conn == null){
			conn = (Connection) ds.getConnection();
			//和当前线程绑定
			tl.set(conn);
		}
		return conn;
	}
	//获取数据源
	public static DataSource getDataSource(){
		return ds;
	}
	//释放资源
	//为啥要写两个释放资源呢？？？？释放规则，先开的后关
	public static void closeResource(Statement st,ResultSet rs){
		closeResultSet(rs);
		closeStatement(st);
		
	}
	
	public static void closeResource(Connection conn, Statement st, ResultSet rs) {
		closeResource(st, rs);
		closeConn(conn);
	}
	private static void closeConn(Connection conn) {
		if(conn != null){
			try {
				conn.close();
				//和线程解绑
				tl.remove();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = null;	
		}
		
	}
	private static void closeStatement(Statement st) {
		if(st != null){
			try {
				st.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			st = null;	
		}
		
	}
	// 释放结果集
		public static void closeResultSet(ResultSet rs) {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				rs = null;
			}
		}
	//开启事务
		public static void startTransaction() throws SQLException{
			getConnection().setAutoCommit(false);//因为默认是不开启事务的
		}	
		
		/**
		 * 事务提交且释放连接
		 */
		public static void commitAndClose(){
			Connection conn = null;
			try {
				conn=getConnection();
				//事务提交
				conn.commit();
				//关闭资源
				conn.close();
				//解除绑定
				tl.remove();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public static void rollbackAndClose(){
			Connection conn = null;
			try {
				conn=getConnection();
				//事务回滚
				conn.rollback();
				//关闭资源
				conn.close();
				//解除绑定
				tl.remove();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
}
