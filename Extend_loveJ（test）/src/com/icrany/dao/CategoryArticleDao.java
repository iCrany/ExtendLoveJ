package com.icrany.dao;

import java.util.List;

import com.icrany.pojo.CategoryArticle;

public interface CategoryArticleDao {
	public int insert(CategoryArticle entity);
	public List<Integer> queryByArticleId(int articleId);
}
