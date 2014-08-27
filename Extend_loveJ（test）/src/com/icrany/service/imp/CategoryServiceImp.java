package com.icrany.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icrany.dao.CategoryDao;
import com.icrany.dao.imp.CategoryDaoImp;
import com.icrany.pojo.Category;
import com.icrany.service.CategoryService;
@Service
public class CategoryServiceImp implements CategoryService{
	
	@Autowired
	private CategoryDao categoryDao ;
	
	public CategoryServiceImp(){
		
	}
	
	@Override
	public boolean save(Category entity) {
		return categoryDao.insert(entity);
	}

	@Override
	public boolean delete(Category entity) {
		return categoryDao.delete(entity);
	}
	
	@Override
	public boolean update(Category entity){
		return categoryDao.update(entity);
	}
	@Override
	public Category findById(int id) {
		return categoryDao.findById(id);
	}
	

	@Override
	public List<Category> findAllCategory() {
		return categoryDao.findAllCategory();
	}
	
}
