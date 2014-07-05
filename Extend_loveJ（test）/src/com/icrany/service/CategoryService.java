package com.icrany.service;

import java.util.List;

import com.icrany.pojo.Category;

public interface CategoryService {
	public boolean save(Category entity);
	public boolean delete(Category entity);
	public boolean update(Category entity);
	public Category findById(int id);
	public List<Category> findAllCategory();
}
