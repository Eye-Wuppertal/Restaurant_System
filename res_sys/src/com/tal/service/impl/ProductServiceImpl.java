package com.tal.service.impl;

import com.tal.domain.PageBean;
import com.tal.domain.Product;
import com.tal.mapper.ProductMapper;
import com.tal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//商品业务逻辑的实现类
@Service("productService")
public class ProductServiceImpl implements ProductService {
	//注入ProductMapper的对象
	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public List<Product> findNewProducts() {
		return productMapper.findNewProducts();
	}

	@Override
	public List<Product> findHotProducts() {
		return productMapper.findHotProducts();
	}

/*	
	//取得指定分类的指定页的商品
	@Override
	public PageBean<Product> findByCidByPage(String cid, int pageNum, int pageSize) {
		
		//得到指定分类下的指定页的商品
		List<Product> list = productMapper.findByCidByPage(cid, (pageNum-1)*pageSize, pageSize);

		//得到指定分类下的商品的总数量
		int recordCount = productMapper.getCountByCid(cid);
		
		//创建PageBean对象，并封装数据
		PageBean<Product> pageBean = new PageBean<Product>( list , pageNum , pageSize , recordCount );
		
		return pageBean;
	}*/

	//取得含关键字的指定页的商品
	@Override
	public PageBean<Product> findByKeywordByCidByPage( String cid , String keyword, int pageNum, int pageSize) {
		//得到指定分类下的指定页的商品
		List<Product> list = productMapper.findByKeywordByCidByPage( cid , keyword, (pageNum-1)*pageSize, pageSize);

		//得到指定分类下的商品的总数量
		int recordCount = productMapper.getCountByKeywordByCid(cid, keyword);
		
		//创建PageBean对象，并封装数据
		PageBean<Product> pageBean = new PageBean<Product>( list , pageNum , pageSize , recordCount );
		
		System.out.println( "====="+pageBean.getRecordCount() );
		System.out.println( "-----" + pageBean.getList());
		return pageBean;
	}

	//根据PID取得商品
	@Override
	public Product findByPid(String pid) {
		return productMapper.findByPid(pid);
	}

}
