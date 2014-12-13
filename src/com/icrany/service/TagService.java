package com.icrany.service;

import java.util.List;

import com.icrany.dao.TagDao;
import org.directwebremoting.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icrany.vo.Tag;
@Service
public class TagService {
	
	private static final Logger logger = Logger.getLogger(TagService.class);
	
	@Autowired
	private TagDao tagDao ;
	
	public Integer insert(Tag entity){
		return tagDao.insert(entity);
	}
	
	public Integer delete(Tag entity){
		return tagDao.delete(entity);
	}
	
	public Tag getById(int id){
		return tagDao.findById(id);
	}
	
	public List<Tag> getAllTag(){
		return tagDao.findAllTag();
	}
	
	public Integer update(Tag entity){
		return tagDao.update(entity);
	}

}
