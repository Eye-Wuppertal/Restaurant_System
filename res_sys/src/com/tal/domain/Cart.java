package com.tal.domain;

import java.util.HashMap;
import java.util.Map;

//购物车的实体类
public class Cart {
	//保存购物车中所有购物项的集合，为了方便查找其中的购物项，使用PID做为Map中的Key
	private Map<String,CartItem> items = new HashMap<String,CartItem>();
	private double total;		//购物车的总计
	
	public Cart(){}
	
	public Map<String, CartItem> getItems() {
		return items;
	}
	public void setItems(Map<String, CartItem> items) {
		this.items = items;
	}
	public double getTotal() {
		this.total = 0;
		//遍历购物车中的所有购物项，累加小计，得到总计
		for ( String pid : items.keySet() ) {
			total += items.get(pid).getSubTotal();
		}
		
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	//把购物项加入到购物车中的方法，已有的商品数量累加
	public void add( CartItem ci ){
		//得到传入的购物项的商品 是否存在于Map集合中
		String pid = ci.getProduct().getPid();
		boolean t = items.containsKey( pid );
		
		if( t ){
			//如果已存在，则数量累加
			CartItem item = items.get(pid);
			int count = item.getCount()+ci.getCount();//购物车中已有的数量加上新传入的购物项的数量
			item.setCount(count);//把累加后的值保存回购物项
			items.put(pid, item);//把购物项保存回Map集合
		}else{
			//如果不存在，则此购物项加入到购物车中
			items.put( pid , ci );
		}
	}

	//删除购物项
	public void remove( String pid ){
		//从Map集合中删除指定Key的元素（PID就是Key）
		items.remove(pid);
	}
	
	public void clear(){
		items.clear();
	}
}
