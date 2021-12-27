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
	
	//把购物项添加到购物车中
	@Override
	public void add(Cart cart, String pid, int count) {
		//调用ProductMapper，根据PID取得商品对象
		Product product = productMapper.findByPid(pid);
		
		//用商品对象和数量（count）封装成一个购物项对象（CartItem）
		CartItem cartItem = new CartItem( product , count );
		
		//把购物项加入到购物车中（如果此商品已存在于购物车中，则数量累加）
		cart.add(cartItem);
	}

	//根据PID，删除购物车中的购物项
	@Override
	public void remove(Cart cart, String pid) {
		//调用购物车对象的remove方法，删除指定的购物项
		cart.remove( pid );
	}

}
