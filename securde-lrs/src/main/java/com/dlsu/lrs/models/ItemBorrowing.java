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

	private boolean isReturned;
	
	private LocalDateTime timestamp;
	
	private LocalDate deadline;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "borrowerId")
	private Account borrower;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "itemId")
	private Item item;

	public ItemBorrowing() {
		this.timestamp = LocalDateTime.now();
	}
	public ItemBorrowing(LocalDate deadline, Account borrower, Item item) {
		this.timestamp = LocalDateTime.now();
		this.deadline = deadline;
		this.borrower = borrower;
		this.item = item;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public boolean isReturned() {
		return isReturned;
	}
	public void setReturned(boolean returned) {
		this.isReturned = returned;
	}
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	public LocalDate getDeadline() {
		return deadline;
	}
	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}
	
	public Account getBorrower() {
		return borrower;
	}
	public void setBorrower(Account borrower) {
		this.borrower = borrower;
	}

	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
}
