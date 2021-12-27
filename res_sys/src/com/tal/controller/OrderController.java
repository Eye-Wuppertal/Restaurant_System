package com.tal.controller;

import com.tal.domain.Cart;
import com.tal.domain.Order;
import com.tal.domain.PageBean;
import com.tal.domain.User;
import com.tal.service.OrderService;
import com.tal.utils.Constract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/order")//�����е����з�����RequestMappingǰ������/order/
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	//���ɶ���
	@RequestMapping("generateOrder")//�൱����Ҫ���ʴ˷�������URLΪ��/order/generateOrder
	public String generateOrder( String[] pid , Integer[] count , Model model , HttpSession session ){
		//��Session��ȡ�õ�ǰ�û������û�У���˵��δ��¼����ת������¼ҳ��
		User user = (User)session.getAttribute( Constract.CURRENT_USER );
				
		//��չ��ﳵ
		Cart cart = (Cart)session.getAttribute("cart");
		cart.clear();
		
		//����ҵ���߼������ɶ���
		Order order = orderService.generateOrder( pid , count , user.getUid() );
		
		//�Ѷ����������а����˶����е����ж�������浽Model������ҳ�������ʾ
		model.addAttribute( "order" , order );
		
		//ת����ȷ�϶�����ҳ��
		return "order_info";
	}
	
	//ȷ�϶���
	@RequestMapping("confirmOrder")
	public String confirmOrder( Order order , Model model ){//�˶��������з�װ��OID��telephone,name,address
		//����ҵ���߼������ջ���Ϣ���µ�������¼�У���Ϊ�˶����Ѳ������ݿ�������Ǹ��£�
		orderService.confirmOrder( order );
		
		//����Ϣ���浽Model
		model.addAttribute( "msg", "����ȷ�ϳɹ���" );
		
		//ת����Ϣҳ�档
		return "info";
	}
	
	
	//��ҳ��ʾ�ҵĶ�������ǰ��¼�û��Ķ������������С���
	@RequestMapping("showMyOrdersByPage")
	public String showMyOrdersByPage( Integer pageNum , Integer pageSize , HttpSession session , Model model ){
		if( pageNum == null ){
			pageNum = 1;
		}
		if( pageSize == null ){
			pageSize = 5;
		}
		
		//ȡ�õ�ǰ�û���Ϣ
		User user = (User)session.getAttribute( Constract.CURRENT_USER );
		
		//���ݵ�ǰ�û���Ϣȡ�ö�������������Ҫ��װ�ö�Ӧ�Ķ������������ҲҪ��װ�ö�Ӧ����Ʒ��
		PageBean<Order> pageBean = orderService.findOrdersByUidByPage( user.getUid() , pageNum , pageSize );
		
		//���浽Model
		model.addAttribute("pageBean" , pageBean);
		
		//ת�������б�ҳ�棨order_list.jsp��
		return "order_list";
	}
	
}
