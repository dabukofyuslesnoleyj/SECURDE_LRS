package com.dlsu.lrs.models;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Account {

	@Id
	private String id;
	
	private boolean isLocked;
	
	private String username;
	
	private String password;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "academicId", nullable = false)
	private Academic academic;
	
	@Embedded
	private AccountSecurity security;
	
	private AccountType type = AccountType.CUSTOMER;
	
	public Account() { }
	public Account(String id, String username, String password, Academic academic, AccountSecurity security, AccountType type) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.academic = academic;
		this.security = security;
		this.type = type;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public boolean isLocked() {
		return isLocked;
	}
	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Academic getAcademic() {
		return academic;
	}
	public void setAcademic(Academic academic) {
		this.academic = academic;
	}
	
	public AccountSecurity getSecurity() {
		return security;
	}
	public void setSecurity(AccountSecurity security) {
		this.security = security;
	}

	public AccountType getType() {
		return type;
	}
	public void setType(AccountType type) {
		this.type = type;
	}
}
