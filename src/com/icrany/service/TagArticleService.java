package com.icrany.service;

import java.util.List;

import com.icrany.dao.TagArticleDao;
import org.directwebremoting.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icrany.vo.TagArticle;
@Service
public class TagArticleService{

	private static final Logger logger = Logger.getLogger(TagArticleService.class);
	
	@Autowired
	private TagArticleDao tagArticleDao ;
	
	public int insert(TagArticle entity) {
		return tagArticleDao.insert(entity);
	}
	
	/**
	 * 用来添加一组int类型数据的标签 和 一个 文章之间的对应关系
	 * @param array
	 * @param articleId
	 * @return
	 */
	public boolean insertArray(int[] array,int articleId){
		for(int i=0;i<array.length;i++){
			TagArticle entity = new TagArticle();
			entity.setArticleId(articleId);
			entity.setTagId(array[i]);
			if(tagArticleDao.insert(entity) == -1){
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * 用来添加一组String类型的数组的标签 和 一个 文章之间的对应关系
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

	public List<Integer> queryByArticleId(int articleId) {
		return tagArticleDao.queryByArticleId(articleId);
	}

	public List<Integer> queryByTagId(int tagId) {
		return tagArticleDao.queryByTagId(tagId);
	}

}
