package com.dlsu.lrs.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.dlsu.lrs.util.Jsonifiable;

@Entity
public class ItemCategory implements Jsonifiable {

	@Id @GeneratedValue
	private int id;
	
	private String name;
	private String description;
	
	public ItemCategory() { }
	public ItemCategory(String name) {
		this();
		setName(name);
	}
	public ItemCategory(String name, String description) {
		this(name);
		setDescription(description);
	}
	
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
	
	@Override
	public String toString() {
		return "ItemCategory [id=" + getId() +
				", name=" + getName() +
				", description=" + getDescription() + "]";
	}
	
}
