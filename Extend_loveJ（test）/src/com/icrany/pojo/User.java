package com.icrany.pojo;

import java.util.Date;

/**
 * 用户类
 * @author Administrator
 *
 */

public class User {
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRoleType() {
		return roleType;
	}

	public void setRoleType(int roleType) {
		this.roleType = roleType;
	}

	private int id;
	
	/**
	 * not null
	 */
	private int age;

	/**
	 * not null
	 */
	private Date birthday;
	
	/**
	 * not null
	 */
	private String email;
	
	/**
	 * not null
	 */
	private boolean gender;
	
	/**
	 * not null
	 */
	private String nickname;
	
	/**
	 * not null
	 */
	private String password;
	
	private String qq;
	
	/**
	 * not null
	 */
	private String username;
	
	private Date createTime;
	
	private String description;
	
	/**
	 * not null
	 */
	private int roleType;

}
