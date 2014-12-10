package com.icrany.dao;

import java.sql.ResultSet;
import java.util.List;

import com.icrany.pojo.Category;

public interface CategoryDao {
	public boolean insert(Category entity);
	public boolean delete(Category entity);
	public Category findById(int id);
	public boolean update(Category entity);
	public List<Category> findAllCategory();
	public Category fillCategory(Category entity,ResultSet rs);
}
