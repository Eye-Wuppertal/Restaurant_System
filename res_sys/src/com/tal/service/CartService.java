package com.tal.service;

import com.tal.domain.Cart;

public interface CartService {
	
	//�ѹ�������ӵ����ﳵ��
	void add( Cart cart , String pid , int count );
	
	//����PID��ɾ�����ﳵ�еĹ�����
	void remove( Cart cart , String pid );

}
