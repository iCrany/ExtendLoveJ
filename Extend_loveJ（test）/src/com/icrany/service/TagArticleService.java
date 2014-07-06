package com.icrany.service;

import java.util.List;

import com.icrany.pojo.TagArticle;

public interface TagArticleService {
	public int insert(TagArticle entity);
	public boolean insertArray(int[] array,int articleId);
	public boolean insertArray(String[] array,int articleId);
	public List<Integer> queryByArticleId(int articleId);
	public List<Integer> queryByTagId(int tagId);	
}
