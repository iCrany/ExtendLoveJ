package com.icrany.dao;

import java.sql.ResultSet;
import java.util.List;

import com.icrany.pojo.Tag;

public interface TagDao {
	public boolean insert(Tag entity);
	public boolean delete(Tag entity);
	public Tag findById(int id);
	public List<Tag> findAllTag();
	public boolean update(Tag entity);
}
