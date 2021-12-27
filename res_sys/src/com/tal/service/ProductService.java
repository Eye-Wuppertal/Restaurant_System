package com.tal.service;

import com.tal.domain.PageBean;
import com.tal.domain.Product;

import java.util.List;

public interface ProductService {

	//取得最新商品，九个
	List<Product> findNewProducts();
	
	//取得热门商品，九个
	List<Product> findHotProducts();
	
	//取得指定分类的指定页的商品
	//PageBean<Product> findByCidByPage( String cid , int pageNum , int pageSize );

	//取得含关键字的指定页的商品
	PageBean<Product> findByKeywordByCidByPage( String cid , String keyword , int pageNum , int pageSize );

	//根据PID取得商品
	Product findByPid( String pid );
}
