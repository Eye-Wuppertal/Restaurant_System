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
	 * 生成订单的业务逻辑
	 * 需要向数据库插入一条订单信息和N条订单项信息
	 * 参数：
	 * 		pids：所有商品的ID
	 * 		counts：所有商品在此订单中的数量（注意两个数组下标是一一对应的）
	 * 		uid：下单的用户ID
	 */
	@Override
	public Order generateOrder(String[] pids, Integer[] counts, String uid) {
		int n = pids.length;//数组长度
		
		String oid = CodeUtils.generateId();//生成随机的OID字符串
		List<OrderItem> list = new ArrayList<OrderItem>();
		double total = 0;//用于累加得到总计结果的变量

		//通过商品ID查询到商品的完整信息，然后通过单价*数量，累加得到总计金额。
		for( int i = 0 ; i < n ; i++ ){
			Product product = productMapper.findByPid(pids[i]);
			double pPrice = product.getpPrice();
			double subTotal = pPrice*counts[i];
			total += subTotal;//本商品在订单项中的数量乘以此商品的单价，得到小计，累加到总计中
			
			OrderItem orderItem = new OrderItem( oid , pids[i] , counts[i] , subTotal , product );
			list.add(orderItem);
		}
		
		//用自定义的构造器生成订单对象（收货人等信息空着）
		Order order = new Order( oid , total , Order.ORDER_STATE_SUBMITED , uid , list );
		
		//订单写入数据库
		orderMapper.insertOrder(order);
		
		//订单项写入数据库
		orderMapper.insertOrderItems(list);
		
		return order;
	}

	
	//确认订单
	@Override
	public void confirmOrder(Order order) {
		//把订单状态置为未制作
		order.setState( Order.ORDER_STATE_CONFIRMED );
		orderMapper.updateOrder(order);
	}

	//分页查询指定用户的订单
	@Override
	public PageBean<Order> findOrdersByUidByPage(String uid, Integer pageNum, Integer pageSize) {
		PageBean<Order> pageBean = new PageBean<Order>();
		
		//先把已有的数据封装到PageBean中
		pageBean.setPageNum(pageNum);
		pageBean.setPageSize(pageSize);
		
		//调用Mapper，取得指定页的订单
		List<Order> list = orderMapper.findOrdersByUidByPage(uid, pageBean.getStartIndex() , pageSize);
		//取得指定用户的订单总数
		int count = orderMapper.getCountByUid(uid);
		//封装到PageBean中
		pageBean.setList(list);
		pageBean.setRecordCount(count);
		
		return pageBean;
	}

}
