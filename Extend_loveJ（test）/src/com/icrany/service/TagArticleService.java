package com.icrany.service;

import com.icrany.pojo.TagArticle;

public interface TagArticleService {
	public int insert(TagArticle entity);
	public boolean insertArray(int[] array,int articleId);
	public boolean insertArray(String[] array,int articleId);
}
