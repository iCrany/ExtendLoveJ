package com.icrany.service.imp;

import java.util.List;

import org.directwebremoting.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icrany.dao.UserDao;
import com.icrany.dao.imp.UserDaoImp;
import com.icrany.pojo.User;
import com.icrany.service.UserService;
@Service
public class UserServiceImp implements UserService {

	private static final Logger logger = Logger.getLogger(UserServiceImp.class);
	
	@Autowired
	private UserDao userDao ;
	
	@Override
	public boolean insert(User entity) {
		return userDao.insert(entity);
	}

	@Override
	public boolean delete(User entity) {
		return userDao.insert(entity);
	}

	@Override
	public boolean updateBase(User entity) {
		return userDao.updateBase(entity);
	}

	@Override
	public User login(User entity) {
		return userDao.login(entity);
	}

	@Override
	public boolean updatePassword(User entity) {
		return userDao.updatePassword(entity);
	}

	@Override
	public List<User> findAllUser() {
		return userDao.findAllUser();
	}

	@Override
	public User find(User entity) {
		return userDao.find(entity);
	}

}
