package com.tal.controller;

import com.tal.domain.PageBean;
import com.tal.domain.Product;
import com.tal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//��Ʒ��صĿ�����
@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	//������Ʒ�ķ��࣬��ҳ��ʾ
	@RequestMapping("/showByCidByKeywordByPage")
	public String showByCidByPage( String cid , String keyword , Integer pageNum , Integer pageSize , Model model ){
		//��ҳ�ź�ҳ��С����Ĭ��ֵ�����������û���ύҳ��ҳ��С����Ĭ��ҳ��Ϊ1��ҳ��СΪ12
		if( pageNum == null ){
			pageNum = 1;
		}
		if( pageSize == null ){
			pageSize = 12;
		}
		
		//��װ�����з�ҳ�����Ϣ�Ķ���
		PageBean<Product> pageBean = productService.findByKeywordByCidByPage(cid, keyword, pageNum, pageSize);
		
		//���浽Model�д���ҳ�������ʾ
		model.addAttribute( "pageBean", pageBean);
		
		//ת������Ʒ�б�ҳ��
		return "product_list";
	}


	//��ʾָ����Ʒ������
	@RequestMapping("/showDetail")
	public String showDetail( String pid , Model model ){
		//����ҵ���߼���ȡ����Ʒ��������Ϣ
		Product product = productService.findByPid(pid);
		
		//����Ʒ���󱣴浽Model
		model.addAttribute( "product" , product);
		
		//ת������Ʒ����ҳ��
		return "product_info";
	}

}
