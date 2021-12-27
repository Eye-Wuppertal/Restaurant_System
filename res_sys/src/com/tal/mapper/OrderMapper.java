package com.tal.mapper;

import com.tal.domain.Order;
import com.tal.domain.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {

	//����һ��������¼
	void insertOrder( Order order );
	
	//����N���������¼
	void insertOrderItems( List<OrderItem> items );
	
	//���¶���
	void updateOrder( Order order );

	//��ҳ��ѯָ���û��Ķ����������������Ʒ��
	List<Order> findOrdersByUidByPage(
			@Param("uid") String uid , 
			@Param("startIndex") int startIndex , 
			@Param("pageSize") int pageSize );
	
	//ȡ��ָ���û��Ķ������������ڷ�ҳ��
	int getCountByUid( String uid );
}
