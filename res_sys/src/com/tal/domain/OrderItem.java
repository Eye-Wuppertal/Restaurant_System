package com.tal.domain;
/*
    @TODO:
    @Author tal
*/

/*
 * CREATE TABLE `tb_orderitem` (
  `oid` varchar(32) DEFAULT NULL,
  `pid` varchar(32) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `subtotal` double DEFAULT NULL
);
 */
//订单项实体类
public class OrderItem {
	private String oid;			//订单ID
	private String pid;			//商品ID
	private int count;			//此订单中此商品的购买数量
	private double subtotal;	//小计
	private com.tal.domain.Product product;	//此订单项对应的商品的对象（一个订单项对应一个商品）
	
	public OrderItem(){}
	
	@Override
	public String toString() {
		return "OrderItem [oid=" + oid + ", pid=" + pid + ", count=" + count + ", subtotal=" + subtotal + "]";
	}

	public OrderItem(String oid, String pid, int count, double subtotal , com.tal.domain.Product product ) {
		super();
		this.oid = oid;
		this.pid = pid;
		this.count = count;
		this.subtotal = subtotal;
		this.product = product;
	}



	public com.tal.domain.Product getProduct() {
		return product;
	}

	public void setProduct(com.tal.domain.Product product) {
		this.product = product;
	}

	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
}
