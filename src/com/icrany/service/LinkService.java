package com.icrany.service;

import java.util.List;

import com.icrany.dao.LinkDao;
import org.directwebremoting.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icrany.vo.Link;
@Service
public class LinkService {

	private static final Logger logger = Logger.getLogger(LinkService.class);
	
	@Autowired
	private LinkDao linkDao ;
	
	public Integer insert(Link entity) {
		return linkDao.insert(entity);
	}

	public Integer delete(Link entity) {
		return linkDao.delete(entity);
	}

	public Link findById(int id) {
		return linkDao.findById(id);
	}

	public List<Link> findAllLink() {
		return linkDao.findAllLink();
	}

	public Integer update(Link entity) {
		return linkDao.update(entity);
	}

	public List<Link> findNewestLink() {
		return linkDao.findNewestLink();
	}

}
