package com.tal.service;

import com.tal.domain.Cart;

public interface CartService {
	
	//�Ѳ�Ʒ��ӵ����ﳵ��
	void add( Cart cart , String pid , int count );
	
	//����PID��ɾ�����ﳵ�еĲ�Ʒ
	void remove( Cart cart , String pid );

}
