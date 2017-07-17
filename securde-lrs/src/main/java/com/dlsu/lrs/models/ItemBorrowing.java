package com.dlsu.lrs.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ItemBorrowing {

	@Id @GeneratedValue
	private long id;
	
	private LocalDateTime timestamp;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "itemId")
	private Item item;
	
	private LocalDate deadline;
	
	private boolean returned;

	public ItemBorrowing() { }
	public ItemBorrowing(Item item, LocalDate deadline) {
		this();
		setItem(item);
		setDeadline(deadline);
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	
	public LocalDate getDeadline() {
		return deadline;
	}
	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

	public boolean isReturned() {
		return returned;
	}
	public void setReturned(boolean returned) {
		this.returned = returned;
	}
}
