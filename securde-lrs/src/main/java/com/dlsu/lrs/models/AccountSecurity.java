package com.dlsu.lrs.models;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

@Embeddable
public class AccountSecurity {

	@OneToOne
	private Account account;
	
	private String question;
	
	private String answer;
	
	public AccountSecurity() { }
	public AccountSecurity(String question, String answer) {
		setQuestion(question);
		setAnswer(answer);
	}
	public AccountSecurity(Account account, String question, String answer) {
		this(question, answer);
		setAccount(account);
	}

	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}

	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
