package com.tal.mapper;

import com.tal.domain.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {

	//取得最新商品，九个
	List<Product> findNewProducts();
	
	//取得热门商品，九个
	List<Product> findHotProducts();

	/*
	//取得指定分类的指定页的商品
	List<Product> findByCidByPage( String cid , int startIndex , int pageSize );
	
	//取得指定分类的记录条数
	int getCountByCid( String cid );
	*/
	
	/*取得含关键字的指定分类下的指定页的商品。
	通过MyBatis提供的注解，给参数加参数名，在Mapper配置文件中就可以用#{参数名}的方式引用此参数
	（用于替代数字下标引用参数的方式）
	还可以使用Map<name,value>的方式传入参数，需要在调用方法之前，把参数封装到Map集合中
	还可以把所有要传入的参数封装成一个JavaBean，属性名就是参数名
	*/
	List<Product> findByKeywordByCidByPage( 
			@Param("cid") String cid, 
			@Param("keyword") String keyword , 
			@Param("startIndex") int startIndex , 
			@Param("pageSize") int pageSize );

	//取得指定分类的含关键字的记录条数
	int getCountByKeywordByCid(
			@Param("cid") String cid, 
			@Param("keyword") String keyword );

	//根据PID取得商品
	Product findByPid(String pid);
}
