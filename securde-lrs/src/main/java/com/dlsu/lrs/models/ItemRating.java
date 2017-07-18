package com.dlsu.lrs.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.dlsu.lrs.util.Jsonifiable;

@Entity
public class ItemRating implements Jsonifiable {

	@Id @GeneratedValue
	private long id;
	
	@ManyToOne
	private Item item;
	@ManyToOne
	private Account account;
	private int rating;
	
	public ItemRating() {
		super();
	}
	public ItemRating(Item item, Account account, int rating) {
		this();
		setItem(item);
		setAccount(account);
		setRating(rating);
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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

	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "ItemRating [id=" + getId() +
				", item=" + getItem() +
				", account=" + getAccount() +
				", rating=" + getRating() + "]";
	}
	
}
