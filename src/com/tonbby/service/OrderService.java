package com.tonbby.service;

import java.util.List;

import com.tonbby.domain.Order;
import com.tonbby.domain.OrderItem;

public interface OrderService {

	public void add(Order order)throws Exception;

	public List<Order> getByUid(String uid) throws Exception;
	

}
