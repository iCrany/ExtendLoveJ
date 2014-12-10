package com.icrany.pojo;

/**
 * 那个播放器中的音乐的一个 pojo
 * @author Administrator
 *
 */
public class Music {
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	private int id;
	
	private String name;
	
	private String url;
	
	private String singer;
	
}
