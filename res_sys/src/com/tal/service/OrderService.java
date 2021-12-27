package com.tal.service;

import com.tal.domain.Order;
import com.tal.domain.PageBean;

public interface OrderService {
	
	Order generateOrder( String[] pids , Integer[] counts , String uid );

	void confirmOrder( Order order );
	
	PageBean<Order> findOrdersByUidByPage( String uid , Integer pageNum , Integer pageSize );
}
