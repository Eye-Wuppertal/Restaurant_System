package com.tal.domain;

//购物项实体类
public class CartItem {
	private com.tal.domain.Product product;	//购物车中的购物项对应的商品
	private int count;			//此购物项有多少个商品
	private double subTotal;	//此购物项的小计（要花多少钱）

	public CartItem(){}
	
	@Override
	public String toString() {
		return "CartItem [product=" + product + ", count=" + count + ", subTotal=" + subTotal + "]";
	}

	public CartItem(com.tal.domain.Product product, int count) {
		super();
		this.product = product;
		this.count = count;
	}
	public com.tal.domain.Product getProduct() {
		return product;
	}
	public void setProduct(com.tal.domain.Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSubTotal() {
		//小计=单价*数量
		this.subTotal = product.getShopPrice()*count;
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
}
