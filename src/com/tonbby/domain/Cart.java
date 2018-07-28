package com.tonbby.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart implements Serializable{

	//购物车
	//购物车项的集合，总计
	private Map<String,CartItem > ItemList = new LinkedHashMap<String, CartItem>();
	private Double Total = 0.0;  //总钱数
	
	
	//提供get  set方法，session域里面那个对象的获取方式好像是它的get方法然后首字母小写
	public Map<String, CartItem> getItemList() {
		return ItemList;
	}
	public void setItemList(Map<String, CartItem> itemList) {
		ItemList = itemList;
	}
	public Double getTotal() {
		return Total;
	}
	public void setTotal(Double total) {
		Total = total;
	}
	/**
	 * 获取所有的购物车项
	 * 把所有的values放到一个集合中，这样方便在jsp中遍历
	 * @return
	 */
	public Collection<CartItem> getItmes(){
		return  ItemList.values();
	}
	/**
	 * addToCart
	 * 把商品项添加到购物车
	 * */
	public Boolean addToCart(CartItem c){
		String pid = c.getProduct().getPid();
		if(pid == null){
			return false;
		}
		if(ItemList.containsKey(pid)){
			//获取到当前的商品项
			CartItem cart = ItemList.get(pid);
			//由于购物车中本来就有这个项，所以只需要将数量更新就行
			//数量为原来的购物车项数量＋新添加的购物车项的数量
			cart.setCount(cart.getCount() + c.getCount());
			
		}else{
			//哈哈哈。注意不要把pid这三个字存进去。。。
			ItemList.put(pid, c);
		
		}
		//只要添加商品了，购物车里保存的总钱数就会更新
		Total = Total + c.getTotal();
		return true;
		
	}
	/**
	 * removeFromCart
	 * 把商品从购物车移除,拿id删除
	 * */
	public boolean removeToCart(String pid){
		if(pid == null){
			return false;
		}
		//从购物车移除，总钱数降低
		System.out.println(ItemList);
		System.out.println("Total"+Total);
		System.out.println(pid);
		Total  = Total - ItemList.remove(pid).getTotal();
		System.out.println("111");
		return true;
		
	}
	/**
	 * EmptyCart
	 * 清空购物车
	 * */
	public void EmptyCart(){
		ItemList.clear();
		Total = 0.0;
	}
	
	
	
	
}
