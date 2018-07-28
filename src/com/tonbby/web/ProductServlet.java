package com.tonbby.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tonbby.domain.PageBean;
import com.tonbby.domain.Product;
import com.tonbby.service.ProductService;
import com.tonbby.service.impl.ProductServiceImpl;
import com.tonbby.utils.BeanFactory;

public class ProductServlet extends BaseServlet {

	/**
	 * 查询单个商品
	 * @throws Exception 
	 * */
	public String getById(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ProductService ps = new ProductServiceImpl();
		String pid = request.getParameter("pid");
		Product p = ps.getById(pid);
		request.setAttribute("product", p);
		
		return "/jsp/product_info.jsp";
	}
	
	/**
	 * 查询分类商品
	 * @throws Exception 
	 * 
	public String getByCid(HttpServletRequest request,HttpServletResponse response) throws Exception{
		//首页上显示的分类的那个超链接，跳到这里来，先获取分类商品，再返回页面，把cid传过来
		ProductService ps = new ProductServiceImpl();
		String cid = request.getParameter("cid");
		System.out.println(cid);
		List<Product> plist = ps.getByCid(cid);
		System.out.println("q11111"+plist);
		if(plist == null){
			System.out.println("木有");
			request.setAttribute("msg", "空空如也");
			return "/jsp/msg.jsp";
		}else {
			response.setContentType("html/text;charset=utf-8");
			request.setAttribute("plist", plist);
			return "/jsp/product_list.jsp";
		}
		
		
		
	}*/
	
	/**
	 * 分页查询数据
	 * */
	public String  findByPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1.获取类别 当前页  设置一个pagesize
		String cid=request.getParameter("cid");
		int currPage=Integer.parseInt(request.getParameter("currPage"));
		System.out.println(cid+"  "+currPage);
		int pageSize=12;
		
		System.out.println("11111111111");
		//2.调用service 返回值pagebean
		ProductService ps=(ProductService) BeanFactory.getBean("ProductService");
		PageBean<Product> bean=ps.findByPage(currPage,pageSize,cid);
		if(bean == null){
			System.out.println("a a a a ");
		}
		//3.将结果放入request中 请求转发
		request.setAttribute("pbean", bean);
		return "/jsp/product_list.jsp";
	}

}
