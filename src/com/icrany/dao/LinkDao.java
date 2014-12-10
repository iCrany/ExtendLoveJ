package com.icrany.dao;

import java.util.List;

import com.icrany.pojo.Link;

public interface LinkDao {
	public boolean insert(Link entity);
	public boolean delete(Link entity);
	public Link findById(int id);
	public List<Link> findAllLink();
	public boolean update(Link entity);
	public List<Link> findNewestLink();
}
