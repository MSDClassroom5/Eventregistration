package com.Eventregistration.domain;

public class Events {

	public Events(long id, String code, String title, String description) {
		super();
		this.id = id;
		this.code = code;
		this.title = title;
		this.description = description;
	}
	
	private long id;
	private String code;
	private String title;
	private String description;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	
}
