package com.dlsu.lrs.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Item {

	@Id @GeneratedValue
	private long id;

	private String name;
	
	private String description;
	
	private Integer year;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "publisherId")
	private ItemPublisher publisher;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "dewey")
	private ItemDewey location;

	private ItemType type = ItemType.BOOK;
	
	private ItemStatus status = ItemStatus.AVAILABLE;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="itemAuthorRel", joinColumns=@JoinColumn(name="itemId"), inverseJoinColumns=@JoinColumn(name="authorId"))  
	private List<ItemAuthor> authors;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="itemCategoryRel", joinColumns=@JoinColumn(name="itemId"), inverseJoinColumns=@JoinColumn(name="categoryId"))  
	@Fetch(value = FetchMode.SUBSELECT)
	private List<ItemTag> tags;

	public Item() { }
	public Item(String name, String desc, Integer year, ItemPublisher publisher, ItemType type, List<ItemAuthor> authors, List<ItemTag> tags) {
		this.name = name;
		this.description = desc;
		this.year = year;
		this.publisher = publisher;
		this.type = type;
		this.authors = authors;
		this.tags = tags;
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
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	
	public ItemPublisher getPublisher() {
		return publisher;
	}
	public void setPublisher(ItemPublisher publisher) {
		this.publisher = publisher;
	}
	
	public ItemDewey getLocation() {
		return location;
	}
	public void setLocation(ItemDewey location) {
		this.location = location;
	}
	
	public ItemType getType() {
		return type;
	}
	public void setType(ItemType type) {
		this.type = type;
	}
	
	public ItemStatus getStatus() {
		return status;
	}
	public void setStatus(ItemStatus status) {
		this.status = status;
	}

	public List<ItemAuthor> getAuthors() {
		return authors;
	}
	public void setAuthors(List<ItemAuthor> authors) {
		this.authors = authors;
	}
	public ItemAuthor getAuthor() {
		return getAuthors().get(0);
	}
	
	public List<ItemTag> getTags() {
		return tags;
	}
	public void setTags(List<ItemTag> tags) {
		this.tags = tags;
	}
}
