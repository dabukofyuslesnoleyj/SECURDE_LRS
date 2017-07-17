package com.dlsu.lrs.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Inventory {

	@Id @GeneratedValue
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Item item;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Dewey location;
	
	private int total;
	
	private int available;
	
	public Inventory() { }
	public Inventory(Item item) {
		this();
		setItem(item);
	}
	public Inventory(Item item, Dewey location) {
		this(item);
		setLocation(location);
	}
	public Inventory(Item item, Dewey location, int count) {
		this(item, location);
		setTotal(count);
		setAvailable(count);
	}
	public Inventory(Item item, Dewey location, int total, int available) {
		this(item, location);
		setTotal(total);
		setAvailable(available);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	
	public Dewey getLocation() {
		return location;
	}
	public void setLocation(Dewey location) {
		this.location = location;
	}
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}

	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
}
