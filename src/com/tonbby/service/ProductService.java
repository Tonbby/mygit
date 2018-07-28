package com.tonbby.service;

import java.util.List;

import com.tonbby.domain.PageBean;
import com.tonbby.domain.Product;

public interface ProductService {

	List<Product> findByNew() throws Exception;

	List<Product> findByHot() throws Exception;

	Product getById(String pid) throws Exception;

	//List<Product> getByCid(String cid) throws Exception;

	PageBean<Product> findByPage(int currPage, int pageSize, String cid) throws Exception;

}
