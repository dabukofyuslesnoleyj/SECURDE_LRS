package com.dlsu.lrs.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ItemReview {

	@Id @GeneratedValue
	private long id;
	
	private LocalDateTime timestamp;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "itemId")
	private Item item;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "accountId")
	private Account account;
	
	private String review;
	
	public ItemReview() {
		this.timestamp = LocalDateTime.now();
	}
	public ItemReview(Item item, Account account, String review) {
		this.item = item;
		this.account = account;
		this.review = review;
		this.timestamp = LocalDateTime.now();
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

	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}

	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
}
