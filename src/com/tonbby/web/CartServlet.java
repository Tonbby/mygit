package com.tonbby.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tonbby.domain.Cart;
import com.tonbby.domain.CartItem;
import com.tonbby.domain.Product;
import com.tonbby.service.ProductService;
import com.tonbby.service.impl.ProductServiceImpl;

//若前面没有public，则出现 Class org.apache.catalina.core.DefaultInstanceManager can not access a member of class
//也就是说，没有权限访问类成员。
public class CartServlet extends BaseServlet {
	
	/**
	 * 获取购物车
	 * */
	public Cart getCart(HttpServletRequest request,HttpServletResponse response){
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if(cart == null){
			Cart c = new Cart();
			request.getSession().setAttribute("cart", c);
			return c;
		}
		
		return cart;
		
	}

	/**
	 * 将商品添加进购物车
	 * @throws Exception 
	 * */
	//java.lang.reflect.InvocationTargetException 最常见错误。所以一般看后面的CauseBy
	public void add(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String pid = request.getParameter("pid");
		Integer count = Integer.parseInt(request.getParameter("count"));
	
		Cart cart = getCart(request, response);
		if(cart == null){
			System.out.println("空的");
		}
		ProductService ps = new ProductServiceImpl();
		Product product = ps.getById(pid);
		//获取到product后，将它变成订单项，然后添加进购物车
	
		CartItem item = new CartItem(product, count);

		System.out.println(item +"  ");
		cart.addToCart(item);
		//重定向？？
		response.sendRedirect(request.getContextPath()+"/jsp/cart.jsp");
	}
	/**
	 * 从购物车移除
	 * @throws IOException 
	 * */
	public void remove(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String pid = request.getParameter("pid");
		
		Cart c = getCart(request,response);
		c.removeToCart(pid);
		request.getSession().setAttribute("cart", c);
		response.sendRedirect(request.getContextPath()+"/jsp/cart.jsp");
	}
	/**
	 * 清空购物车
	 * @throws IOException 
	 * */
	public void clear(HttpServletRequest request,HttpServletResponse response) throws IOException{
		Cart c = getCart(request, response);
		c.EmptyCart();
		request.getSession().setAttribute("cart", c);
		response.sendRedirect(request.getContextPath()+"/jsp/cart.jsp");
	}
}
