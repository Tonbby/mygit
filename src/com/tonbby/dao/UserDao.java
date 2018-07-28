package com.tonbby.dao;

import java.sql.SQLException;

import com.tonbby.domain.User;

public interface UserDao {
	//子类不能抛出比父类更大的异常
	void add(User user) throws SQLException;

	User getByCode(String code) throws Exception;

	void update(User user) throws Exception;

	User getByUserNameandPwd(String username, String password) throws Exception;

	
}
