package com.tonbby.domain;

import java.io.Serializable;

public class CartItem  implements Serializable{

	//购物车项 ，商品，数量，小计
	private Product product;
	private Integer count;
	private Double total;  //小计，没有set方法，get方法直接计算出来的
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getTotal() {
		return product.getShop_price()*count;
	}
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartItem(Product product, Integer count) {
		//构造方法里将商品和数量已经存入进去
		super();
		this.product = product;
		this.count = count;
	}
	
	
	
	
}
