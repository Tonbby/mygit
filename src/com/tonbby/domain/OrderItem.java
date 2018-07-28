package com.tonbby.domain;

import java.io.Serializable;

public class OrderItem implements Serializable {

	private String itemid;
	private Integer count;
	private Double subtotal;
	private String pid;
	private String oid;
	private Product product;
	private Order order;
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public OrderItem(String itemid, Integer count, Double subtotal, String pid, String oid, Product product,
			Order order) {
		super();
		this.itemid = itemid;
		this.count = count;
		this.subtotal = subtotal;
		this.pid = pid;
		this.oid = oid;
		this.product = product;
		this.order = order;
	}
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
