package com.tal.service.impl;

import com.tal.domain.Category;
import com.tal.mapper.CategoryMapper;
import com.tal.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryMapper categoryMapper;

	//ȡ�����з�����Ϣ
	@Override
	public List<Category> findAll() {
		return categoryMapper.findAll();
	}

}
