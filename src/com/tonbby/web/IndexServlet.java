package com.tonbby.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tonbby.domain.Category;
import com.tonbby.domain.Product;
import com.tonbby.service.CategoryService;
import com.tonbby.service.ProductService;
import com.tonbby.service.impl.CategoryServiceImpl;
import com.tonbby.service.impl.ProductServiceImpl;

public class IndexServlet extends BaseServlet {

	///帮助跳转到首页
	public String index(HttpServletRequest request,HttpServletResponse response) throws Exception{
//		CategoryService cs = new CategoryServiceImpl();
//		List<Category> list = cs.FindAll();
//		request.setAttribute("clist", list);
		
		//页面加载的时候，查询最新商品和热门商品
		//查询的结果两个List，将两个list放入request域中，请求转发到index.jsp上
		ProductService ps = new ProductServiceImpl();
		
		List<Product> list1 = ps.findByNew();
		System.out.println("!!!");
		List<Product> list2 = ps.findByHot();
		
		request.setAttribute("list1", list1);
		request.setAttribute("list2", list2);
		System.out.println("？？？");
		return "/jsp/index.jsp";
		//return null;
		
	}
	
}
