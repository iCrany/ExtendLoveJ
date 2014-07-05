package com.icrany.service.imp;

import java.util.List;

import com.icrany.dao.CategoryDao;
import com.icrany.dao.imp.CategoryDaoImp;
import com.icrany.pojo.Category;
import com.icrany.service.CategoryService;

public class CategoryServiceImp implements CategoryService{
	
	private static CategoryDao categoryDao = new CategoryDaoImp();
	
	public CategoryServiceImp(){
		
	}
	
	@Override
	public boolean save(Category entity) {
		// TODO Auto-generated method stub
		return categoryDao.insert(entity);
	}

	@Override
	public boolean delete(Category entity) {
		// TODO Auto-generated method stub
		return categoryDao.delete(entity);
	}
	
	@Override
	public boolean update(Category entity){
		return categoryDao.update(entity);
	}
	@Override
	public Category findById(int id) {
		// TODO Auto-generated method stub
		return categoryDao.findById(id);
	}
	

	@Override
	public List<Category> findAllCategory() {
		// TODO Auto-generated method stub
		return categoryDao.findAllCategory();
	}
	
}
