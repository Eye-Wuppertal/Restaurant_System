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
@RequestMapping("/order")//本类中的所有方法的RequestMapping前都会有/order/
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	//生成订单
	@RequestMapping("generateOrder")//相当于是要访问此方法，则URL为：/order/generateOrder
	public String generateOrder( String[] pid , Integer[] count , Model model , HttpSession session ){
		//从Session中取得当前用户，如果没有，则说明未登录，则转跳到登录页面
		User user = (User)session.getAttribute( Constract.CURRENT_USER );
				
		//清空购物车
		Cart cart = (Cart)session.getAttribute("cart");
		cart.clear();
		
		//调用业务逻辑，生成订单
		Order order = orderService.generateOrder( pid , count , user.getUid() );
		
		//把订单对象（其中包含此订单中的所有订单项）保存到Model，带到页面进行显示
		model.addAttribute( "order" , order );
		
		//转跳到确认订单的页面
		return "order_info";
	}
	
	//确认订单
	@RequestMapping("confirmOrder")
	public String confirmOrder( Order order , Model model ){//此订单对象中封装了OID、telephone,name,address
		//调用业务逻辑，把收货信息更新到订单记录中（因为此订单已插入数据库表，所以是更新）
		orderService.confirmOrder( order );
		
		//把信息保存到Model
		model.addAttribute( "msg", "订单确认成功！" );
		
		//转跳信息页面。
		return "info";
	}
	
	
	//分页显示我的订单（当前登录用户的订单，降序排列。）
	@RequestMapping("showMyOrdersByPage")
	public String showMyOrdersByPage( Integer pageNum , Integer pageSize , HttpSession session , Model model ){
		if( pageNum == null ){
			pageNum = 1;
		}
		if( pageSize == null ){
			pageSize = 5;
		}
		
		//取得当前用户信息
		User user = (User)session.getAttribute( Constract.CURRENT_USER );
		
		//根据当前用户信息取得订单（订单中需要封装好对应的订单项，订单项中也要封装好对应的商品）
		PageBean<Order> pageBean = orderService.findOrdersByUidByPage( user.getUid() , pageNum , pageSize );
		
		//保存到Model
		model.addAttribute("pageBean" , pageBean);
		
		//转跳订单列表页面（order_list.jsp）
		return "order_list";
	}
	
}
