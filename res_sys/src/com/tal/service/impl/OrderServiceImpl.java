package com.tal.service.impl;

import com.tal.domain.Order;
import com.tal.domain.OrderItem;
import com.tal.domain.PageBean;
import com.tal.domain.Product;
import com.tal.mapper.OrderMapper;
import com.tal.mapper.ProductMapper;
import com.tal.service.OrderService;
import com.tal.utils.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private ProductMapper productMapper;

	/*
	 * ���ɶ�����ҵ���߼�
	 * ��Ҫ�����ݿ����һ��������Ϣ��N����������Ϣ
	 * ������
	 * 		pids��������Ʒ��ID
	 * 		counts��������Ʒ�ڴ˶����е�������ע�����������±���һһ��Ӧ�ģ�
	 * 		uid���µ����û�ID
	 */
	@Override
	public Order generateOrder(String[] pids, Integer[] counts, String uid) {
		int n = pids.length;//���鳤��
		
		String oid = CodeUtils.generateId();//���������OID�ַ���
		List<OrderItem> list = new ArrayList<OrderItem>();
		double total = 0;//�����ۼӵõ��ܼƽ���ı���

		//ͨ����ƷID��ѯ����Ʒ��������Ϣ��Ȼ��ͨ������*�������ۼӵõ��ܼƽ�
		for( int i = 0 ; i < n ; i++ ){
			Product product = productMapper.findByPid(pids[i]);
			double pPrice = product.getpPrice();
			double subTotal = pPrice*counts[i];
			total += subTotal;//����Ʒ�ڶ������е��������Դ���Ʒ�ĵ��ۣ��õ�С�ƣ��ۼӵ��ܼ���
			
			OrderItem orderItem = new OrderItem( oid , pids[i] , counts[i] , subTotal , product );
			list.add(orderItem);
		}
		
		//���Զ���Ĺ��������ɶ��������ջ��˵���Ϣ���ţ�
		Order order = new Order( oid , total , Order.ORDER_STATE_SUBMITED , uid , list );
		
		//����д�����ݿ�
		orderMapper.insertOrder(order);
		
		//������д�����ݿ�
		orderMapper.insertOrderItems(list);
		
		return order;
	}

	
	//ȷ�϶���
	@Override
	public void confirmOrder(Order order) {
		//�Ѷ���״̬��Ϊδ����
		order.setState( Order.ORDER_STATE_CONFIRMED );
		orderMapper.updateOrder(order);
	}

	//��ҳ��ѯָ���û��Ķ���
	@Override
	public PageBean<Order> findOrdersByUidByPage(String uid, Integer pageNum, Integer pageSize) {
		PageBean<Order> pageBean = new PageBean<Order>();
		
		//�Ȱ����е����ݷ�װ��PageBean��
		pageBean.setPageNum(pageNum);
		pageBean.setPageSize(pageSize);
		
		//����Mapper��ȡ��ָ��ҳ�Ķ���
		List<Order> list = orderMapper.findOrdersByUidByPage(uid, pageBean.getStartIndex() , pageSize);
		//ȡ��ָ���û��Ķ�������
		int count = orderMapper.getCountByUid(uid);
		//��װ��PageBean��
		pageBean.setList(list);
		pageBean.setRecordCount(count);
		
		return pageBean;
	}

}
