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
	
	private ItemType type;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "publisherId")
	private ItemPublisher publisher;
	
	private Integer year;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="itemAuthorRel", joinColumns=@JoinColumn(name="itemId"), inverseJoinColumns=@JoinColumn(name="authorId"))  
	private List<ItemAuthor> authors;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="itemCategoryRel", joinColumns=@JoinColumn(name="itemId"), inverseJoinColumns=@JoinColumn(name="categoryId"))  
	@Fetch(value = FetchMode.SUBSELECT)
	private List<ItemCategory> categories;

	public Item() { }
	public Item(String name) {
		this();
		setName(name);
	}
	public Item(String name, ItemType type) {
		this(name);
		setType(type);
	}
	public Item(String name, ItemType type, List<ItemAuthor> authors) {
		this(name, type);
		setAuthors(authors);
	}
	public Item(String name, ItemType type, ItemPublisher publisher, Integer year, List<ItemAuthor> authors) {
		this(name, type, authors);
		setPublisher(publisher);
		setYear(year);
	}
	public Item(String name, ItemType type, ItemPublisher publisher, Integer year, List<ItemAuthor> authors, List<ItemCategory> categories) {
		this(name, type, publisher, year, authors);
		setCategories(categories);
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
	
	public ItemType getType() {
		return type;
	}
	public void setType(ItemType type) {
		this.type = type;
	}
	
	public ItemPublisher getPublisher() {
		return publisher;
	}
	public void setPublisher(ItemPublisher publisher) {
		this.publisher = publisher;
	}
	
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
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

	public List<ItemCategory> getCategories() {
		return categories;
	}
	public void setCategories(List<ItemCategory> categories) {
		this.categories = categories;
	}
}
