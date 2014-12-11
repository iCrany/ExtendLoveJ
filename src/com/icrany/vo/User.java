package com.icrany.vo;

import org.kidding.orm.entity.POJO;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户类
 * @author Administrator
 *
 */
@Table(name="user")
public class User extends POJO implements Serializable {
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
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

	public Boolean isGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
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

	public Integer getRoleType() {
		return roleType;
	}

	public void setRoleType(Integer roleType) {
		this.roleType = roleType;
	}

	@Id
	private Integer id;
	
	/**
	 * not null
	 */
	private Integer age;

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
	private Boolean gender;
	
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
	private Integer roleType;

}
