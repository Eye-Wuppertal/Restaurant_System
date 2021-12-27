package com.tal.domain;

//������ʵ����
public class CartItem {
	private com.tal.domain.Product product;	//���ﳵ�еĹ������Ӧ����Ʒ
	private int count;			//�˹������ж��ٸ���Ʒ
	private double subTotal;	//�˹������С�ƣ�Ҫ������Ǯ��

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
		//С��=����*����
		this.subTotal = product.getShopPrice()*count;
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
}
