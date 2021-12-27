package com.tal.service.impl;

import com.tal.domain.PageBean;
import com.tal.domain.Product;
import com.tal.mapper.ProductMapper;
import com.tal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//��Ʒҵ���߼���ʵ����
@Service("productService")
public class ProductServiceImpl implements ProductService {
	//ע��ProductMapper�Ķ���
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
	//ȡ��ָ�������ָ��ҳ����Ʒ
	@Override
	public PageBean<Product> findByCidByPage(String cid, int pageNum, int pageSize) {
		
		//�õ�ָ�������µ�ָ��ҳ����Ʒ
		List<Product> list = productMapper.findByCidByPage(cid, (pageNum-1)*pageSize, pageSize);

		//�õ�ָ�������µ���Ʒ��������
		int recordCount = productMapper.getCountByCid(cid);
		
		//����PageBean���󣬲���װ����
		PageBean<Product> pageBean = new PageBean<Product>( list , pageNum , pageSize , recordCount );
		
		return pageBean;
	}*/

	//ȡ�ú��ؼ��ֵ�ָ��ҳ����Ʒ
	@Override
	public PageBean<Product> findByKeywordByCidByPage( String cid , String keyword, int pageNum, int pageSize) {
		//�õ�ָ�������µ�ָ��ҳ����Ʒ
		List<Product> list = productMapper.findByKeywordByCidByPage( cid , keyword, (pageNum-1)*pageSize, pageSize);

		//�õ�ָ�������µ���Ʒ��������
		int recordCount = productMapper.getCountByKeywordByCid(cid, keyword);
		
		//����PageBean���󣬲���װ����
		PageBean<Product> pageBean = new PageBean<Product>( list , pageNum , pageSize , recordCount );
		
		System.out.println( "====="+pageBean.getRecordCount() );
		System.out.println( "-----" + pageBean.getList());
		return pageBean;
	}

	//����PIDȡ����Ʒ
	@Override
	public Product findByPid(String pid) {
		return productMapper.findByPid(pid);
	}

}
