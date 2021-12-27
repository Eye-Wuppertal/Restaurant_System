package com.tal.mapper;

import com.tal.domain.Order;
import com.tal.domain.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {

	//插入一条订单记录
	void insertOrder( Order order );
	
	//插入N条订单项记录
	void insertOrderItems( List<OrderItem> items );
	
	//更新订单
	void updateOrder( Order order );

	//分页查询指定用户的订单（含订单项和商品）
	List<Order> findOrdersByUidByPage(
			@Param("uid") String uid , 
			@Param("startIndex") int startIndex , 
			@Param("pageSize") int pageSize );
	
	//取得指定用户的订单总数（用于分页）
	int getCountByUid( String uid );
}
