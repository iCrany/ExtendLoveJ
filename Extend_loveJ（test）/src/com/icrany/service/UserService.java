package com.icrany.service;

import java.util.List;

import com.icrany.pojo.User;

public interface UserService {
	public boolean insert(User entity);
	public boolean delete(User entity);
	public boolean updateBase(User entity);
	public boolean updatePassword(User entity);
	public User login(User entity);
	public List<User> findAllUser();
	public User find(User entity);
}
