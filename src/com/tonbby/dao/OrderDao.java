package com.tonbby.dao;

import java.util.List;

import com.tonbby.domain.Order;
import com.tonbby.domain.OrderItem;

public interface OrderDao {
	
	public void addOrder(Order order) throws Exception;
	public void addOrderItem(OrderItem oi) throws Exception;
	public List<Order> getByUid(String uid) throws Exception;
	public List<OrderItem> getByOid(String oid) throws Exception;

}
