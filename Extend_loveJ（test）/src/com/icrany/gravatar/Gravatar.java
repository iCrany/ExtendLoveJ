package com.icrany.gravatar;

import com.icrany.util.MD5Util;

/**
 * Gravatar 头像支持类
 * @author <a href="http://www.icrany.com">iCrany</a>
 * 2014年9月3日 下午11:02:31
 */
public class Gravatar {
	
	/**
	 * 默认的 头像大小 px
	 */
	private static final int DEFAULT_SIZE = 80;
	
	/**
	 * 默认的头像图片
	 */
	private static final Image DEFAULT_IMAGE = Image.Identicon; 
	
	/**
	 * 默认的头像图片的等级
	 */
	private static final Rating DEFAULT_RATING = Rating.G;
	
	/**
	 * gravatar 的域名
	 */
	private static final String HTTP_URL = "http://www.gravatar.com/avatar/";
	
	/**
	 * 1px up to 2048px
	 */
	private int size = DEFAULT_SIZE;
	
	private Image image = DEFAULT_IMAGE;
	
	private Rating rating = DEFAULT_RATING;
	
	/**
	 * 根据用户的 email 生成对应的 hash 码，并且将相应的一些参数拼接起来，返回一个完整的 url 
	 * @return
	 */
	public String getGravatarUrl(){
		
		String emailHash = MD5Util.md5Hex(this.email.toLowerCase().trim());//都需要小写
		String parameters = getUrlParameters();
		String gravatarUrl = HTTP_URL + emailHash + parameters;
		return gravatarUrl;
	}
	
	/**
	 * 将具体的参数格式化
	 * @return
	 */
	public String getUrlParameter(){
		
		return null;
	}
	
	/**
	 * 将所有需要拼接到 url 的参数格式化
	 * @return
	 */
	public String getUrlParameters(){
		
		return null;
	}
	
	/**
	 * 用户的 email
	 */
	private String email ;
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getEmail(){
		return this.email;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}
}
