package com.icrany.view;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * 那个播放器中的音乐的一个 vo
 * @author Administrator
 *
 */
public class Music implements Serializable {
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	private Integer id;
	
	private String name;
	
	private String url;
	
	private String singer;
	
}
