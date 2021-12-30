package com.tal.service;

import com.tal.domain.PageBean;
import com.tal.domain.Product;

import java.util.List;

public interface ProductService {

	//ȡ�����²�Ʒ���Ÿ�
	List<Product> findNewProducts();
	
	//ȡ�����Ų�Ʒ���Ÿ�
	List<Product> findHotProducts();
	
	//ȡ��ָ�������ָ��ҳ�Ĳ�Ʒ
	//PageBean<Product> findByCidByPage( String cid , int pageNum , int pageSize );

	//ȡ�ú��ؼ��ֵ�ָ��ҳ�Ĳ�Ʒ
	PageBean<Product> findByKeywordByCidByPage( String cid , String keyword , int pageNum , int pageSize );

	//����PIDȡ�ò�Ʒ
	Product findByPid( String pid );
}
