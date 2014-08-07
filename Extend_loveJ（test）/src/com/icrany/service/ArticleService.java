package com.icrany.service;

import java.util.List;

import com.icrany.pojo.Article;

public interface ArticleService{
	public int insert(Article entity);
	public boolean delete(Article entity);
	public boolean deleteAllPage();
	public Article queryById(int id);
	public boolean update(Article entity);
	public List<Article> findPage();
	public List<Article> getAllArticle();
	public List<Article> findNavMenuItem();
	public List<Article> findNewestArticle();
	public List<Article> findByFuzzyName(String key);
}
