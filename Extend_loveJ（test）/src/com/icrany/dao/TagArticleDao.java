package com.icrany.dao;

import java.util.List;

import com.icrany.pojo.TagArticle;

public interface TagArticleDao {
	public int insert(TagArticle entity);
	public List<Integer> queryByArticleId(int articleId);
	public List<Integer> queryByTagId(int tagId);
}
