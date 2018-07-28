package com.tonbby.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public class Order implements Serializable{

	private String oid;
	private String ordertime;
	private Double total = 0.0;
	private Integer state = 0;  //0：未支付 1：已支付
	private String address;
	private String name ;
	private String telephone;
	private String uid;
	//一个用户可以有很多个订单，所以每个订单都关联了一下用户
	
	private User user; 
	//一个订单里面有很多订单项。订单项里面存的是产品
	private List<OrderItem> items = new LinkedList<OrderItem>();
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(String date) {
		this.ordertime = date;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<OrderItem> getItems() {
		return items;
	}
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	public Order(String oid, String ordertime, Double total, String address, String name, String telephone,
			String uid, User user, List<OrderItem> items) {
		super();
		this.oid = oid;
		this.ordertime =  ordertime;
		this.total = total;
		this.address = address;
		this.name = name;
		this.telephone = telephone;
		this.uid = uid;
		this.user = user;
		this.items = items;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
