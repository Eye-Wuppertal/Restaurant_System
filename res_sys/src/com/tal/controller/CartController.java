package com.tal.controller;

import com.tal.domain.Cart;
import com.tal.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

//���ﳵ��ص�������Controller
@Controller
public class CartController {
	
	@Autowired
	private CartService cartService;

	/*���һ����������ﳵ��
	 * pid:��ƷID
	 * count:Ҫ���뵽���ﳵ�е�����
	 */
	@RequestMapping("/addCartItem")
	public String addCartItem( String pid , Integer count , HttpSession session ){
		//��Session��ȡ�ù��ﳵ������������ڣ��򴴽�һ���µĹ��ﳵ����
		Cart cart = (Cart)session.getAttribute("cart");
		
		if( cart == null ){
			cart = new Cart();
		}
		
		//����ҵ���߼������µ���Ʒ���뵽���ﳵ��
		cartService.add( cart , pid , count );
		
		//�ѹ��ﳵ���浽Session��
		session.setAttribute( "cart" , cart );
		
		//ת�������ﳵҳ��
		return "cart";
	}
	
	//ɾ��������
	@RequestMapping("/removeCartItem")
	public String removeCartItem( String pid , HttpSession session ){
		//��Session����ȡ�ù��ﳵ������Ϊͬɾ������������Ĭ�Ϲ��ﳵ����Ϊ�գ�
		Cart cart = (Cart)session.getAttribute("cart");
		
		//����ҵ���߼���ɾ��ָ���Ĺ�����(����PIDɾ����Ӧ�Ĺ�����)
		cartService.remove( cart , pid );
		
		return "cart";
	}
	
	//��չ��ﳵ
	@RequestMapping("/clearCart")
	public String clearCart( HttpSession session ){
		
		session.removeAttribute("cart");
		
		
		return "cart";
	}
	
	//ת�������ﳵҳ��
	@RequestMapping("/showCart")
	public String showCart(){
		return "cart";
	}
	
}
