package com.tal.controller;

import com.tal.domain.PageBean;
import com.tal.domain.Product;
import com.tal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//商品相关的控制器
@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	//根据商品的分类，分页显示
	@RequestMapping("/showByCidByKeywordByPage")
	public String showByCidByPage( String cid , String keyword , Integer pageNum , Integer pageSize , Model model ){
		//给页号和页大小设置默认值，如果请求中没有提交页号页大小，则默认页号为1，页大小为12
		if( pageNum == null ){
			pageNum = 1;
		}
		if( pageSize == null ){
			pageSize = 12;
		}
		
		//封装了所有分页相关信息的对象
		PageBean<Product> pageBean = productService.findByKeywordByCidByPage(cid, keyword, pageNum, pageSize);
		
		//保存到Model中带到页面进行显示
		model.addAttribute( "pageBean", pageBean);
		
		//转跳到商品列表页面
		return "product_list";
	}


	//显示指定商品的详情
	@RequestMapping("/showDetail")
	public String showDetail( String pid , Model model ){
		//调用业务逻辑，取得商品的完整信息
		Product product = productService.findByPid(pid);
		
		//把商品对象保存到Model
		model.addAttribute( "product" , product);
		
		//转跳到商品详情页面
		return "product_info";
	}

}
