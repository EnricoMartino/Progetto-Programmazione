package com.example;

public class Organization {
	
	private String id;
	private String title;
	private String description;
	private String image;
	private String name;
	
	public Organization(String id, String title, String description, String image, String name) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.image = image;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Organization [id=" + id + ", title=" + title + ", description=" + description + ", image=" + image
				+ ", name=" + name + "]";
	}
	
	

	
}
