package com.tal.service;

import com.tal.domain.Category;

import java.util.List;

//分类的业务逻辑
public interface CategoryService {

	//取得所有分类信息
	List<Category> findAll();
}
