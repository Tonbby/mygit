package com.tonbby.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tonbby.dao.ProductDao;
import com.tonbby.domain.Category;
import com.tonbby.domain.PageBean;
import com.tonbby.domain.Product;
import com.tonbby.utils.DataSourceUtils1;

public class ProductDaoImpl implements ProductDao{

	/**
	 * 查询最新
	 * */
	public List<Product> findByNew() throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils1.getDataSource());
	//里面不用加分hao
		String sql = "select * from product order by pdate desc limit 9";
		
		//Cannot set cid: incompatible types数据库类型与实体类型不一致
		return qr.query(sql, new BeanListHandler(Product.class));
		
	}
	/**
	 * 查询热门
	 * */

	public List<Product> findByHot() throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils1.getDataSource());
		
		String sql = "select * from product where is_hot = 1 order by pdate limit 9"; 
		return qr.query(sql, new BeanListHandler(Product.class));
	}
	/**
	 * 查询单个商品
	 * */
	public Product getById(String pid) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils1.getDataSource());
		String sql = "select * from product where pid = ? limit 1";
		return qr.query(sql, new BeanHandler(Product.class),pid);
	}
	/**
	 * 查询分类商品
	 * 
	
	public List<Product> getByCid(String cid) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where cid = ? limit 9";
		System.out.println("111111111");
		return qr.query(sql, new BeanListHandler(Product.class),cid);
	}*/
	
	/**
	 * 查询当前页商品
	 * */
	public List<Product> findByPage(int currPage, int pageSize, String cid) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils1.getDataSource());
		String sql = "select * from product where cid = ? limit ?,? ";
		
		return  qr.query(sql, new BeanListHandler(Product.class), cid,(currPage-1)*pageSize,pageSize);
	}
	
	
	/**
	 * 查询当前类别的总条数
	 * */
	public int getTotalCount(String cid) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
