package com.dlsu.lrs.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ItemPublisher {

	@Id @GeneratedValue
	private long id;
	
	private String name;
	
	private String address;
	
	public ItemPublisher() { }
	public ItemPublisher(String name) {
		this();
		setName(name);
	}
	public ItemPublisher(String name, String address) {
		this(name);
		setAddress(address);
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
