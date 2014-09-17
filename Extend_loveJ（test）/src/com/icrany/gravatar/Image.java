package com.icrany.gravatar;

/**
 * gravatar 的头像枚举类
 * @author <a href="http://www.icrany.com">iCrany</a>
 * 2014年9月3日 下午10:59:25
 */
public enum Image {
	
	Http404("404"),//do not load any image if none is associated with the email hash, instead return an HTTP 404 (File Not Found) response
	
	Identicon("identicon"),//a geometric pattern based on an email hash
	
	Monsterid("monsterid"),//a generated 'monster' with different colors, faces, etc
	
	Wavatar("wavatar"),//generated faces with differing features and backgrounds
	
	Retro("retro"),//awesome generated, 8-bit arcade-style pixelated faces
	
	Blank("blank"),// a transparent PNG image (border added to HTML below for demonstration purposes)
	
	MysteryMan("mystery-man");//a simple, cartoon-style silhouetted outline of a person (does not vary by email hash)
	
	private String image ;
	
	private Image(){
		
	}
	
	private Image(String image){
		this.image = image;
	}
	
	public String getImage(){
		return this.image;
	}
}
