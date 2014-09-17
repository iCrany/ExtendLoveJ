package com.icrany.gravatar;

/**
 * gravatar 头像的等级分类 
 * @author <a href="http://www.icrany.com">iCrany</a>
 * 2014年9月3日 下午10:51:04
 */
public enum Rating {
	
	G("g"),//suitable for display on all websites with any audience type
	
	PG("pg"),//may contain rude gestures, provocatively dressed individuals, the lesser swear words, or mild violence
	
	R("r"),//may contain such things as harsh profanity, intense violence, nudity, or hard drug use
	
	X("x");//may contain hardcore sexual imagery or extremely disturbing violence
	
	private String rating;
	
	private Rating(){
		
	}
	
	private Rating(String rating){
		
	}
	
	public String getRating(){
		return this.rating;
	}
}
