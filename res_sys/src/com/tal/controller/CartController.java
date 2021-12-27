package com.tal.controller;

import com.tal.domain.Cart;
import com.tal.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

//购物车相关的请求处理Controller
@Controller
public class CartController {
	
	@Autowired
	private CartService cartService;

	/*添加一个购物项到购物车中
	 * pid:商品ID
	 * count:要加入到购物车中的数量
	 */
	@RequestMapping("/addCartItem")
	public String addCartItem( String pid , Integer count , HttpSession session ){
		//从Session中取得购物车对象，如果不存在，则创建一个新的购物车对象
		Cart cart = (Cart)session.getAttribute("cart");
		
		if( cart == null ){
			cart = new Cart();
		}
		
		//调用业务逻辑，把新的商品加入到购物车中
		cartService.add( cart , pid , count );
		
		//把购物车保存到Session域
		session.setAttribute( "cart" , cart );
		
		//转跳到购物车页面
		return "cart";
	}
	
	//删除购物项
	@RequestMapping("/removeCartItem")
	public String removeCartItem( String pid , HttpSession session ){
		//从Session域中取得购物车对象（因为同删除操作，所以默认购物车对象不为空）
		Cart cart = (Cart)session.getAttribute("cart");
		
		//调用业务逻辑，删除指定的购物项(根据PID删除对应的购物项)
		cartService.remove( cart , pid );
		
		return "cart";
	}
	
	//清空购物车
	@RequestMapping("/clearCart")
	public String clearCart( HttpSession session ){
		
		session.removeAttribute("cart");
		
		
		return "cart";
	}
	
	//转跳到购物车页面
	@RequestMapping("/showCart")
	public String showCart(){
		return "cart";
	}
	
}
