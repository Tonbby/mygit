package com.tonbby.service.impl;

import java.util.List;

import com.tonbby.dao.ProductDao;
import com.tonbby.dao.impl.ProductDaoImpl;
import com.tonbby.domain.PageBean;
import com.tonbby.domain.Product;
import com.tonbby.service.ProductService;
import com.tonbby.utils.BeanFactory;

public class ProductServiceImpl implements ProductService {

	/**
	 * 查询最新
	 * */
	public List<Product> findByNew() throws Exception {
		ProductDao pd = new ProductDaoImpl();
		return pd.findByNew();
	}

	/**
	 * 查询热门
	 * */
	public List<Product> findByHot() throws Exception {
		ProductDao pd = new ProductDaoImpl();
		return pd.findByHot();
	}

	/**
	 * 查询单个商品
	 * */
	public Product getById(String pid) throws Exception {
		ProductDao pd = new ProductDaoImpl();
		return pd.getById(pid);
	}
	/**
	 * 查询分类商品
	 * 

	public List<Product> getByCid(String cid) throws Exception {
		ProductDao pd = new ProductDaoImpl();
		return pd.getByCid(cid);
	}*/
	
	/**
	 * 查询当前页商品
	 * */
	public PageBean<Product> findByPage(int currPage, int pageSize, String cid) throws Exception {
		ProductDao pd = (ProductDao) BeanFactory.getBean("ProductDao");
		//当前页数据
		List<Product> list =  pd.findByPage(currPage, pageSize, cid);
		//PageBean里面有一个list，可以把它包装进去。然后返回。
		int totalCount = pd.getTotalCount(cid);
		
		return new PageBean<Product>(list, currPage, pageSize, totalCount);
	}

}
