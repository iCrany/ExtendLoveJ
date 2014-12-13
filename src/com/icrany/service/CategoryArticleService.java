package com.icrany.service;

import java.util.List;

import com.icrany.dao.CategoryArticleDao;
import org.directwebremoting.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icrany.vo.CategoryArticle;
@Service
public class CategoryArticleService {

	private static final Logger logger = Logger.getLogger(CategoryArticleService.class);
	
	@Autowired
	private CategoryArticleDao categoryArticleDao ;
	
	public int insert(CategoryArticle entity) {
		return categoryArticleDao.insert(entity);
	}
	
	/**
	 * 用来添加一组int类型数据的分类 和 一个 文章之间的对应关系
	 * @param array
	 * @param articleId
	 * @return
	 */
	public boolean insertArray(int[] array,int articleId){
		for(int i=0;i<array.length;i++){
			CategoryArticle entity = new CategoryArticle();
			entity.setArticleId(articleId);
			entity.setCategoryId(array[i]);
			if(categoryArticleDao.insert(entity) == -1){
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * 用来添加一组String类型的数组的分类 和 一个 文章之间的对应关系
	 * @param array
	 * @param articleId
	 * @return
	 */
	public boolean insertArray(String[] array,int articleId){
		int[] newArray = new int[array.length];
		for(int i = 0; i< array.length ;i++){
			newArray[i] = Integer.parseInt(array[i]);
		}
		return insertArray(newArray,articleId);
	}

	public List<CategoryArticle> queryByCategoryId(int categoryId) {
		return categoryArticleDao.queryByCategoryId(categoryId);
	}

	public List<CategoryArticle> queryByArticleId(Integer articleId) {
		return categoryArticleDao.queryByArticleId(articleId);
	}

}
