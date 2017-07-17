package com.dlsu.lrs.models;

import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Account extends _Prototype_AppModel {

	@Id
	private String id;
	
	private String username;
	
	private String password;
	
	private AccountType type = AccountType.STUDENT;
	
	@ElementCollection
	private Map<AccountPrivilege, Boolean> privileges;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "academicId", nullable = false)
	private Academic academic;
	
	@Embedded
	private AccountSecurity security;
	
	public Account() { }
	public Account(String id, Academic academic) {
		setId(id);
		setAcademic(academic);
	}
	public Account(String id, Academic academic, String username, String password) {
		this(id, academic);
		setUsername(username);
		setPassword(password);
	}
	public Account(String id, Academic academic, String username, String password, AccountType type, Map<AccountPrivilege, Boolean> privileges, AccountSecurity security) {
		this(id, academic, username, password);
		setType(type);
		setPrivileges(privileges);
		setSecurity(security);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	
	public AccountType getType() {
		return type;
	}
	public void setType(AccountType type) {
		this.type = type;
	}
	
	public Map<AccountPrivilege, Boolean> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(Map<AccountPrivilege, Boolean> privileges) {
		this.privileges = privileges;
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
}
