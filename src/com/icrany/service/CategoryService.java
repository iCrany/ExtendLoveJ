package com.icrany.service;

import java.util.List;

import com.icrany.dao.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icrany.vo.Category;
@Service
public class CategoryService {
	
	@Autowired
	private CategoryDao categoryDao ;
	
	public CategoryService(){
		
	}

	public Integer save(Category entity) {
		return categoryDao.insert(entity);
	}

	public Integer delete(Category entity) {
		return categoryDao.delete(entity);
	}
	
	public Integer update(Category entity){
		return categoryDao.update(entity);
	}

	public Category findById(int id) {
		return categoryDao.findById(id);
	}
	
	public List<Category> findAllCategory() {
		return categoryDao.findAllCategory();
	}
	
}
