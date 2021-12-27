package com.tal.service;

import com.tal.domain.Cart;

public interface CartService {
	
	//把购物项添加到购物车中
	void add( Cart cart , String pid , int count );
	
	//根据PID，删除购物车中的购物项
	void remove( Cart cart , String pid );

}
