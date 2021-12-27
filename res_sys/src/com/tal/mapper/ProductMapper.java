package com.tal.mapper;

import com.tal.domain.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {

	//ȡ��������Ʒ���Ÿ�
	List<Product> findNewProducts();
	
	//ȡ��������Ʒ���Ÿ�
	List<Product> findHotProducts();

	/*
	//ȡ��ָ�������ָ��ҳ����Ʒ
	List<Product> findByCidByPage( String cid , int startIndex , int pageSize );
	
	//ȡ��ָ������ļ�¼����
	int getCountByCid( String cid );
	*/
	
	/*ȡ�ú��ؼ��ֵ�ָ�������µ�ָ��ҳ����Ʒ��
	ͨ��MyBatis�ṩ��ע�⣬�������Ӳ���������Mapper�����ļ��оͿ�����#{������}�ķ�ʽ���ô˲���
	��������������±����ò����ķ�ʽ��
	������ʹ��Map<name,value>�ķ�ʽ�����������Ҫ�ڵ��÷���֮ǰ���Ѳ�����װ��Map������
	�����԰�����Ҫ����Ĳ�����װ��һ��JavaBean�����������ǲ�����
	*/
	List<Product> findByKeywordByCidByPage( 
			@Param("cid") String cid, 
			@Param("keyword") String keyword , 
			@Param("startIndex") int startIndex , 
			@Param("pageSize") int pageSize );

	//ȡ��ָ������ĺ��ؼ��ֵļ�¼����
	int getCountByKeywordByCid(
			@Param("cid") String cid, 
			@Param("keyword") String keyword );

	//����PIDȡ����Ʒ
	Product findByPid(String pid);
}
