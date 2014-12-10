package com.icrany.service;

import java.util.List;

import com.icrany.pojo.Tag;

public interface TagService {
	
	public boolean insert(Tag entity);
	public boolean delete(Tag entity);
	public Tag getById(int id);
	public List<Tag> getAllTag();
	public boolean update(Tag entity);
}
