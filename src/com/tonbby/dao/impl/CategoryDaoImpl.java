package com.tonbby.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tonbby.dao.CategoryDao;
import com.tonbby.domain.Category;
import com.tonbby.utils.DataSourceUtils1;

public class CategoryDaoImpl implements CategoryDao {

	public List<Category> FindAll() throws SQLException{
		QueryRunner qr = new QueryRunner(new DataSourceUtils1().getDataSource());
		String sql = "select * from Category";
		
		return qr.query(sql, new BeanListHandler(Category.class));
		
	}
}
