package com.tal.domain;

import java.util.HashMap;
import java.util.Map;

//���ﳵ��ʵ����
public class Cart {
	//���湺�ﳵ�����й�����ļ��ϣ�Ϊ�˷���������еĹ����ʹ��PID��ΪMap�е�Key
	private Map<String,CartItem> items = new HashMap<String,CartItem>();
	private double total;		//���ﳵ���ܼ�
	
	public Cart(){}
	
	public Map<String, CartItem> getItems() {
		return items;
	}
	public void setItems(Map<String, CartItem> items) {
		this.items = items;
	}
	public double getTotal() {
		this.total = 0;
		//�������ﳵ�е����й�����ۼ�С�ƣ��õ��ܼ�
		for ( String pid : items.keySet() ) {
			total += items.get(pid).getSubTotal();
		}
		
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	//�ѹ�������뵽���ﳵ�еķ��������е���Ʒ�����ۼ�
	public void add( CartItem ci ){
		//�õ�����Ĺ��������Ʒ �Ƿ������Map������
		String pid = ci.getProduct().getPid();
		boolean t = items.containsKey( pid );
		
		if( t ){
			//����Ѵ��ڣ��������ۼ�
			CartItem item = items.get(pid);
			int count = item.getCount()+ci.getCount();//���ﳵ�����е����������´���Ĺ����������
			item.setCount(count);//���ۼӺ��ֵ����ع�����
			items.put(pid, item);//�ѹ�������Map����
		}else{
			//��������ڣ���˹�������뵽���ﳵ��
			items.put( pid , ci );
		}
	}

	//ɾ��������
	public void remove( String pid ){
		//��Map������ɾ��ָ��Key��Ԫ�أ�PID����Key��
		items.remove(pid);
	}
	
	public void clear(){
		items.clear();
	}
}
