package com.icrany.pojo;

public class Tag {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isTrash() {
		return trash;
	}

	public void setTrash(boolean trash) {
		this.trash = trash;
	}

	private int id;
	
	private String name;
	
	private String description;
	
	private boolean trash;
}
