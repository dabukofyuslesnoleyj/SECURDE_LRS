package com.dlsu.lrs.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.dlsu.lrs.util.Jsonifiable;

@Entity
public class Account implements Jsonifiable {

	@Id
	private String id;
	
	private String username;
	private String password;
	
	private AccountType type = AccountType.STUDENT;
	
	@ElementCollection
	private List<AccountPrivilege> privileges = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="academicId", nullable=false)
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
	public Account(String id, Academic academic, String username, String password, AccountType type, List<AccountPrivilege> privileges, AccountSecurity security) {
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
	
	public List<AccountPrivilege> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(List<AccountPrivilege> privileges) {
		this.privileges = privileges;
	}
	public boolean hasPrivilege(AccountPrivilege privilege) {
		return getPrivileges().contains(privilege);
	}
	public void addPrivilege(AccountPrivilege privilege) {
		getPrivileges().add(privilege);
	}
	public void removePrivilege(AccountPrivilege privilege) {
		getPrivileges().remove(privilege);
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
	
	@Override
	public String toString() {
		return "Account [id=" + id +
				", username=" + username +
				", password=" + password +
				", type=" + type +
				", privileges=" + privileges +
				", academic=" + academic +
				", security=" + security + "]";
	}
}
