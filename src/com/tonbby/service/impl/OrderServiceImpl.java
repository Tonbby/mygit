package com.tonbby.service.impl;

import java.util.List;

import com.tonbby.dao.OrderDao;
import com.tonbby.dao.ProductDao;
import com.tonbby.dao.impl.OrderDaoImpl;
import com.tonbby.dao.impl.ProductDaoImpl;
import com.tonbby.domain.Order;
import com.tonbby.domain.OrderItem;
import com.tonbby.service.OrderService;
import com.tonbby.utils.DataSourceUtils1;

public class OrderServiceImpl implements OrderService {

	/**
	 * 添加订单
	 * */
	public void add(Order order) throws Exception {
		
		try {
			DataSourceUtils1.startTransaction();
			/**
			 * java.lang.reflect.InvocationTargetException
			 * 这个错误太常见了、主要看的是后面的cause by
			 * */
			System.out.println("!!11");
			List<OrderItem> list = order.getItems();
			
			OrderDao od = new OrderDaoImpl();
			od.addOrder(order);
			for (OrderItem orderItem : list) {
				od.addOrderItem(orderItem);
			}
			
			
			DataSourceUtils1.commitAndClose();
		} catch (Exception e) {
			DataSourceUtils1.rollbackAndClose();
			throw e;
		}
		
		
		
		
	}
	/**
	 * 通过uid查询查询订单,根据订单的oid从订单中查询出List订单项，然后封装到订单中。
	 * orderList(里面的每一项里都有一个orderitemLIst)
	 * */
	public List<Order> getByUid(String uid) throws Exception {
		OrderDao od = new OrderDaoImpl();
		ProductDao pd = new ProductDaoImpl();
		List<Order> list =  od.getByUid(uid);
		//获取每一项order,将olist封装进去
		for (Order order : list) {
			String oid = order.getOid();
			List<OrderItem> olist = od.getByOid(oid);
			//然后，通过pid，将product查询出来，封装到orderitem的product中
			//一个订单项对应一个product
			for (OrderItem orderItem : olist) {
				orderItem.setProduct(pd.getById(orderItem.getPid()));
			}
			order.setItems(olist);
		}
	
		
		return list;
		
	}

}
