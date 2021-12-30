package com.tal.domain;
/*
    @TODO:
    @Author tal
*/
import java.util.Date;
import java.util.List;

/*
 * CREATE TABLE `tb_order` (
  `oid` varchar(32) PRIMARY KEY,
  `ordertime` timestamp,
  `total` double DEFAULT NULL,
  `state` int(1) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `uid` varchar(32) DEFAULT NULL
);
 */
//订单的实体类
public class Order {
	
	public static final int ORDER_STATE_SUBMITED = 1;	
	public static final int ORDER_STATE_CONFIRMED = 2;
	public static final int ORDER_STATE_SENDED = 3;

	
	private String oid;			//订单ID
	private Date ordertime;		//下单时间
	private double total;		//总计
	private int state;			//订单状态：1、已提交。2、制作中。3、已完成
	private String uid;			//下单的ID
	private List<com.tal.domain.OrderItem> items;		//此订单下的所有订单项对象的List集合
	
	public List<com.tal.domain.OrderItem> getItems() {
		return items;
	}

	public void setItems(List<com.tal.domain.OrderItem> items) {
		this.items = items;
	}

	public Order(){}
	
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", ordertime=" + ordertime + ", total=" + total + ", state=" + state + ",  uid=" + uid + "]";
	}

	public Order(String oid, double total, int state, String uid , List<com.tal.domain.OrderItem> items ) {
		super();
		this.oid = oid;
		this.total = total;
		this.state = state;
		this.uid = uid;
		this.items = items;
	}



	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}

}
