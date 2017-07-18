package com.dlsu.lrs.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.dlsu.lrs.util.Jsonifiable;

@Entity
public class ItemBorrowing implements Jsonifiable {

	@Id @GeneratedValue
	private long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime timestamp;
	
	@ManyToMany
	private List<Item> items;
	
	private LocalDate deadline;

	public ItemBorrowing() { }
	public ItemBorrowing(List<Item> items, LocalDate deadline) {
		this();
		setItems(items);
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

	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}

	public LocalDate getDeadline() {
		return deadline;
	}
	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}
	
	@Override
	public String toString() {
		return "ItemBorrowing [id=" + getId() +
				", timestamp=" + getTimestamp() +
				", items=" + getItems() +
				", deadline=" + getDeadline()  + "]";
	}
}
