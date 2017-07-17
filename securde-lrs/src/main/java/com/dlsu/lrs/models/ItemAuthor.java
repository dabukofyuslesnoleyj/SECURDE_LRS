package com.dlsu.lrs.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ItemAuthor {

	@Id @GeneratedValue
	private int id;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;

	public ItemAuthor() { }
	public ItemAuthor(String firstName, String lastName) {
		this();
		setFirstName(firstName);
		setLastName(lastName);
	}
	public ItemAuthor(String firstName, String middleName, String lastName) {
		this(firstName, lastName);
		setMiddleName(middleName);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getMiddleInitial() {
		if(getMiddleName() == null || getMiddleName().length() == 0)
			return null;
		return getMiddleName().charAt(0) + "";
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
