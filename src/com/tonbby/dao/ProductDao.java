package com.tonbby.dao;

import java.util.List;

import com.tonbby.domain.PageBean;
import com.tonbby.domain.Product;

public interface ProductDao {

	List<Product> findByNew() throws Exception;

	List<Product> findByHot() throws Exception;

	Product getById(String pid) throws Exception;

	//List<Product> getByCid(String cid) throws Exception;

	List<Product> findByPage(int currPage, int pageSize, String cid) throws Exception;

	int getTotalCount(String cid) throws Exception;

}
