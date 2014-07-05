package com.icrany.service;

import com.icrany.pojo.CategoryArticle;

public interface CategoryArticleService {
	public int insert(CategoryArticle entity);
	public boolean insertArray(int[] array,int articleId);
	public boolean insertArray(String[] array,int articleId);
}
