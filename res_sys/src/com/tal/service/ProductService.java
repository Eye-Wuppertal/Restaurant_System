package com.tal.service;

import com.tal.domain.PageBean;
import com.tal.domain.Product;

import java.util.List;

public interface ProductService {

	//ȡ��������Ʒ���Ÿ�
	List<Product> findNewProducts();
	
	//ȡ��������Ʒ���Ÿ�
	List<Product> findHotProducts();
	
	//ȡ��ָ�������ָ��ҳ����Ʒ
	//PageBean<Product> findByCidByPage( String cid , int pageNum , int pageSize );

	//ȡ�ú��ؼ��ֵ�ָ��ҳ����Ʒ
	PageBean<Product> findByKeywordByCidByPage( String cid , String keyword , int pageNum , int pageSize );

	//����PIDȡ����Ʒ
	Product findByPid( String pid );
}
