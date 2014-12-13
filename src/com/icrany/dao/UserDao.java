package com.icrany.dao;
import java.util.List;

import com.icrany.system.Constants;
import org.directwebremoting.util.Logger;
import org.kidding.orm.dao.imp.BaseDAO;
import org.springframework.stereotype.Repository;

import com.icrany.vo.User;

@Repository
public class UserDao extends BaseDAO<User>{

	private static final Logger logger = Logger.getLogger(UserDao.class);

	public UserDao() throws IllegalAccessException, InstantiationException {
		super(Constants.DB_ALIAS,User.class);
	}

	/**
	 * 添加新的标签
	 * @param entity
	 * @return
	 */
	public Integer insert(User entity){
		return this.save(entity);
	}
	
	/**
	 * 根据 id 来删除用户
	 * @param entity
	 * @return
	 */
	public Integer delete(User entity){

		try {
			return this._delete(entity, false);
		}catch(Exception e){
			logger.error("删除用户失败！！！",e);
		}
		return -1;
	}
	
	
	/**
	 * 更新用户信息
	 * @param entity
	 * @return
	 */
	public Integer updateBase(User entity){
		try {
			return this._update(entity, false);
		}catch(Exception e){
			logger.error("更新用户失败！！！",e);
		}
		return -1;
	}
	
	/**
	 * 更新用户密码
	 * @param entity
	 * @return
	 */
	public Integer updatePassword(User entity){

		try {
			return this._update(entity, false);
		}catch(Exception e){
			logger.error("更新用户密码失败！！！",e);
		}
		return -1;
	}
	
	/**
	 * 检查用户的登录信息
	 * @param entity
	 * @return
	 */
	public User login(User entity){
		return this.get(entity);
	}
	
	/**
	 * 查找出所有的用户
	 * @return
	 */
	public List<User> findAllUser(){
		try {
			User entity = new User();
			return this.list(entity, null, null, null);
		}catch(Exception e){
			logger.error("获取所有用户数据出错！！！",e);
		}
		return null;
	}
	
	/**
	 * 需要注意的是这里默认是只有一位用户的就是管理员所以该方法和 findAllUser 方法没有区别
	 */
	public User find(User entity){
		return this.get(entity);
	}
}
