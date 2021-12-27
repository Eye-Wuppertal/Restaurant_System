package com.tal.service.impl;

import com.tal.domain.Cart;
import com.tal.domain.CartItem;
import com.tal.domain.Product;
import com.tal.mapper.ProductMapper;
import com.tal.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("cartService")
public class CartServiceImpl implements CartService {

	@Autowired
	private ProductMapper productMapper;
	
	//�ѹ�������ӵ����ﳵ��
	@Override
	public void add(Cart cart, String pid, int count) {
		//����ProductMapper������PIDȡ����Ʒ����
		Product product = productMapper.findByPid(pid);
		
		//����Ʒ�����������count����װ��һ�����������CartItem��
		CartItem cartItem = new CartItem( product , count );
		
		//�ѹ�������뵽���ﳵ�У��������Ʒ�Ѵ����ڹ��ﳵ�У��������ۼӣ�
		cart.add(cartItem);
	}

	//����PID��ɾ�����ﳵ�еĹ�����
	@Override
	public void remove(Cart cart, String pid) {
		//���ù��ﳵ�����remove������ɾ��ָ���Ĺ�����
		cart.remove( pid );
	}

}
