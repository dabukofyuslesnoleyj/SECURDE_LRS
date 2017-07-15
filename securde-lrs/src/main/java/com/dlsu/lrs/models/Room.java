package com.dlsu.lrs.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.dlsu.lrs.util.Jsonifiable;

@Entity
public class Room implements Jsonifiable {

	@Id @GeneratedValue
	private long id;
	private String name;
	
	public Room() { }
	public Room(String name) {
		this();
		setName(name);
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
	
	@Override
	public String toString() {
		return "Room [id=" + getId() +
				", name=" + getName() + "]";
	}
}
