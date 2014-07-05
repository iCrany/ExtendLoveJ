package com.icrany.service.imp;

import java.util.List;

import org.directwebremoting.util.Logger;

import com.icrany.dao.LinkDao;
import com.icrany.dao.imp.LinkDaoImp;
import com.icrany.pojo.Link;
import com.icrany.service.LinkService;

public class LinkServiceImp implements LinkService {

	private static final Logger logger = Logger.getLogger(LinkServiceImp.class);
	
	private static LinkDao linkDao = new LinkDaoImp();
	
	@Override
	public boolean insert(Link entity) {
		return linkDao.insert(entity);
	}

	@Override
	public boolean delete(Link entity) {
		return linkDao.delete(entity);
	}

	@Override
	public Link findById(int id) {
		return linkDao.findById(id);
	}

	@Override
	public List<Link> findAllLink() {
		return linkDao.findAllLink();
	}

	@Override
	public boolean update(Link entity) {
		return linkDao.update(entity);
	}

	@Override
	public List<Link> findNewestLink() {
		return linkDao.findNewestLink();
	}

}
