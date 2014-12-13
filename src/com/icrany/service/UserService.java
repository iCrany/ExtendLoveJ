package com.icrany.service;

import java.util.List;

import com.icrany.dao.UserDao;
import org.directwebremoting.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icrany.vo.User;
@Service
public class UserService {

	private static final Logger logger = Logger.getLogger(UserService.class);
	
	@Autowired
	private UserDao userDao ;
	
	public Integer insert(User entity) {
		return userDao.insert(entity);
	}

	public Integer delete(User entity) {
		return userDao.insert(entity);
	}

	public Integer updateBase(User entity) {
		return userDao.updateBase(entity);
	}

	public User login(User entity) {
		return userDao.login(entity);
	}

	public Integer updatePassword(User entity) {
		return userDao.updatePassword(entity);
	}

	public List<User> findAllUser() {
		return userDao.findAllUser();
	}

	public User find(User entity) {
		return userDao.find(entity);
	}

}
