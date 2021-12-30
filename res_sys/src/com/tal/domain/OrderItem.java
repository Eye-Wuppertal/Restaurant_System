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
//������ʵ����
public class OrderItem {
	private String oid;			//����ID
	private String pid;			//��ƷID
	private int count;			//�˶����д���Ʒ�Ĺ�������
	private double subtotal;	//С��
	private com.tal.domain.Product product;	//�˶������Ӧ����Ʒ�Ķ���һ���������Ӧһ����Ʒ��
	
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
