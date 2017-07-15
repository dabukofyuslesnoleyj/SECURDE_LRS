package com.dlsu.lrs.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.dlsu.lrs.util.Jsonifiable;

@Entity
public class ItemReview implements Jsonifiable {

	@Id @GeneratedValue
	private long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime timestamp;
	
	@ManyToMany
	private Item item;
	@ManyToMany
	private Account account;
	private String review;
	
	public ItemReview() { }
	public ItemReview(Item item, Account account, String review) {
		this();
		setItem(item);
		setAccount(account);
		setReview(review);
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
	
	@Override
	public String toString() {
		return "ItemRating [id=" + getId() +
				", timestamp=" + getTimestamp() +
				", item=" + getItem() +
				", account=" + getAccount() +
				", review=" + getReview() + "]";
	}
}
