package com.dlsu.lrs.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Dewey {

	@Id
	private String id;
	private String description;
	
	public Dewey() { }
	public Dewey(String id) {
		this();
		setId(id);
	}
	public Dewey(String id, String description) {
		this(id);
		setDescription(description);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
