package com.tonbby.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

import com.sun.jmx.snmp.Timestamp;
import com.tonbby.domain.Cart;
import com.tonbby.domain.CartItem;
import com.tonbby.domain.Order;
import com.tonbby.domain.OrderItem;
import com.tonbby.domain.User;
import com.tonbby.service.OrderService;
import com.tonbby.service.impl.OrderServiceImpl;
import com.tonbby.utils.UUIDUtils;

public class OrderServlet extends BaseServlet {
	//注意：若购物车中已经有商品，添加的时候应该在原来的那个商品上加一，而不是那啥
/**
 * 添加订单/提交订单
 * @throws Exception 
 * 
 * */
	public String add(HttpServletRequest request,HttpServletResponse response) throws Exception{
		//判断用户是否登录
		User user = (User) request.getSession().getAttribute("user");
		response.setContentType("text/html;charset=utf-8");
		//	也可以同时加上这句：
			response.setCharacterEncoding("UTF-8");
		if(user == null){
			System.out.println("用户没有登录");
			return "/jsp/login.jsp";
		}
		//封装数据
		Order order = new Order();
		//调用service添加订单
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if(cart == null){
			System.out.println("空空如也");
		}else{
			/**
			 * 把cartItem遍历，组装成OrderItem
			 * */
			
			Collection<CartItem>  list1 =  cart.getItmes();
			order.setOid(UUIDUtils.getId());
			order.setUid(user.getUid());
			//所以。date和data的区别是什么？？？
			//
			String d = new Date().toString();
			System.out.println(d);
			order.setOrdertime(d);
			for (CartItem cartItem : list1) {
				OrderItem item = new OrderItem();
				item.setCount(cartItem.getCount());
				item.setItemid(UUIDUtils.getId());
				item.setOid(order.getOid());
				item.setOrder(order);
				item.setPid(cartItem.getProduct().getPid());
				item.setProduct(cartItem.getProduct());
				item.setSubtotal(cartItem.getTotal());
				order.getItems().add(item);
			}
			//小心乱码
//			String a = request.getParameter("address");
//			String n = request.getParameter("name");
//			String t = request.getParameter("telephone");
			order.setUser(user);
			order.setTotal(order.getTotal()+cart.getTotal());
			OrderService os = new OrderServiceImpl();
			
			os.add(order);
			request.getSession().setAttribute("order", order);
			
		}
		
		
		return "/jsp/order_info.jsp";
		
	}
	/**
	 * 将订单展示出来
	 * @throws Exception 
	 * */
	public String showOrders(HttpServletRequest request,HttpServletResponse response) throws Exception{
		User user = (User) request.getSession().getAttribute("user");
		if(user == null){
			return "/jsp/login.jsp";
		}
		//根据uid查询用户的订单
		OrderService os = new OrderServiceImpl();
		System.out.println(user.getUid());
		List<Order> orderlist = os.getByUid(user.getUid());
		System.out.println(orderlist);
		System.out.println(orderlist.get(0).getItems().get(0).getProduct());
		request.setAttribute("orderlist", orderlist);
		//jstl的标签里面不能有空格！！！！！
		return "/jsp/order_list.jsp";
		
	}
}
