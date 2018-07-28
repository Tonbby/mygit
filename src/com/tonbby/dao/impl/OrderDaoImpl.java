package com.tonbby.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tonbby.dao.OrderDao;
import com.tonbby.domain.Order;
import com.tonbby.domain.OrderItem;
import com.tonbby.utils.DataSourceUtils;
import com.tonbby.utils.DataSourceUtils1;

public class OrderDaoImpl implements OrderDao {

	/**
	 * 添加订单
	 * */
	public void addOrder(Order order) throws Exception {
		QueryRunner qr = new QueryRunner();
		String sql = "insert into orders values(?,?,?,?,?,?,?,?)";
		//时间有点问题
		//Fri Jun 01 10:08:57 GMT+08:00 2018
		//错误瞎几把提示，本质错误其实是sql语句写错了。。。
		System.out.println(order );
		//int i = order.getState();
		qr.update(DataSourceUtils.getConnection(),sql, order.getOid(),order.getOrdertime(),order.getTotal(),order.getState(),
				order.getAddress(),order.getName(),order.getTelephone(),order.getUser().getUid());
		
	}

	/**
	 * 添加订单项
	 * 一个订单里有n个订单项，拿循环在service层一个一个添加的
	 * */
	public void addOrderItem(OrderItem oi) throws Exception {
		/**
		 * `itemid` varchar(32) NOT NULL,orders
		  `count` int(11) DEFAULT NULL,
		  `subtotal` double DEFAULT NULL,
		  `pid` varchar(32) DEFAULT NULL,
		  `oid` varchar(32) DEFAULT NULL
		 * */
		QueryRunner qr = new QueryRunner();
		String sql = "insert into orderitem values(?,?,?,?,?)";
		qr.update(DataSourceUtils.getConnection(),sql, oi.getItemid(),oi.getCount(),oi.getSubtotal(),
				oi.getProduct().getPid(),oi.getOrder().getOid());
		
	}
	/**
	 * 查询用户的订单信息
	 * */

	public List<Order> getByUid(String uid) throws Exception {
		//Unknown column
		//给字符类型的数据加上引号就ok
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		//记住是orders
		//Cannot set ordertime: incompatible types
		//数据库查询类型与类里面的类型不匹配
		
		String sql = "select * from orders where uid = ?";
		List<Order> list = qr.query(sql, new BeanListHandler(Order.class), uid);
 		return list;
	}

	/**
	 * 根据订单id，查询每一个订单的订单项，并存入order中
	 * */
	public List<OrderItem> getByOid(String oid) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from orderitem where oid = ?";
		
		return qr.query(sql, new BeanListHandler(OrderItem.class), oid);
	}

}
