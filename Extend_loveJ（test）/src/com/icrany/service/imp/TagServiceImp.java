package com.icrany.service.imp;

import java.util.List;

import org.directwebremoting.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icrany.dao.TagDao;
import com.icrany.dao.imp.TagDaoImp;
import com.icrany.pojo.Tag;
import com.icrany.service.TagService;
@Service
public class TagServiceImp implements TagService {
	
	private static final Logger logger = Logger.getLogger(TagServiceImp.class);
	
	@Autowired
	private TagDao tagDao ;
	
	public boolean insert(Tag entity){
		return tagDao.insert(entity);
	}
	
	public boolean delete(Tag entity){
		return tagDao.delete(entity);
	}
	
	public Tag getById(int id){
		return tagDao.findById(id);
	}
	
	public List<Tag> getAllTag(){
		return tagDao.findAllTag();
	}
	
	public boolean update(Tag entity){
		return tagDao.update(entity);
	}

}
