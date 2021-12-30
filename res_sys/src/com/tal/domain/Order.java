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
//������ʵ����
public class Order {
	
	public static final int ORDER_STATE_SUBMITED = 1;	
	public static final int ORDER_STATE_CONFIRMED = 2;
	public static final int ORDER_STATE_SENDED = 3;

	
	private String oid;			//����ID
	private Date ordertime;		//�µ�ʱ��
	private double total;		//�ܼ�
	private int state;			//����״̬��1�����ύ��2�������С�3�������
	private String uid;			//�µ���ID
	private List<com.tal.domain.OrderItem> items;		//�˶����µ����ж���������List����
	
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
