package com.tonbby.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.tonbby.dao.UserDao;
import com.tonbby.domain.User;
import com.tonbby.utils.DataSourceUtils1;

public class UserDaoImpl implements UserDao{

	/**
	 * 用户注册
	 * @throws SQLException 
	 * */
	public void add(User user) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils1.getDataSource());

		String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";

		System.out.println(user.getName());
		
		qr.update(sql, user.getUid(),user.getUsername(),user.getPassword(),
				user.getName(),user.getEmail(),user.getTelephone(),
				user.getBirthday(),user.getSex(),user.getState(),user.getCode());

		
	}

	public User getByCode(String code) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils1.getDataSource());
		String sql = "select * from user where code = ? limit 1";
		return qr.query(sql, new BeanHandler(User.class),code);
		
		
	}

	public void update(User user) throws Exception {
		//通用的update
		QueryRunner qr = new QueryRunner(DataSourceUtils1.getDataSource());
		
		//日了够了。。。是pwd不是password......
		String sql="update user set username = ?,password = ? ,name=?,email=?,birthday = ?,state = ?,code=? where uid =? ";
		qr.update(sql, user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),user.getBirthday(),
				1,null,user.getUid());
		
	}
	/**
	 * 用户登录
	 * */
	public User getByUserNameandPwd(String username, String password) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils1.getDataSource());
		String sql = "select * from user where username = ? and password = ? limit 1";
		return  qr.query(sql, new BeanHandler(User.class),username,password);
		
		
		
	}

	

	

}
