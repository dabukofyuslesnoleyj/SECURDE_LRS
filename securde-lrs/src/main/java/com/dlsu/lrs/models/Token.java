package com.dlsu.lrs.models;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Deprecated
@Entity
public class Token {

	@Id @GeneratedValue
	private long id;

	@Basic(optional = false)
	private String token;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "userId")
	private Academic academic;
	
	@Basic(optional = false)
	private AccountType type = AccountType.STUDENT;

	public Token() { }
	public Token(String token, Academic user) {
		this();
		setToken(token);
		setAcademic(user);
	}
	public Token(String token, Academic user, AccountType type) {
		this(token, user);
		setType(type);
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	public Academic getAcademic() {
		return academic;
	}
	public void setAcademic(Academic academic) {
		this.academic = academic;
	}

	public AccountType getType() {
		return type;
	}
	public void setType(AccountType type) {
		this.type = type;
	}
}
