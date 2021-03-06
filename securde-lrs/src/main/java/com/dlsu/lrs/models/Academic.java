package com.dlsu.lrs.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.dlsu.lrs.util.Jsonifiable;

@Entity
public class Academic implements Jsonifiable {

	@Id
	private String id;
	
	private String firstName;
	private String middleName;
	private String lastName;
	
	private AcademicType type = AcademicType.STUDENT;
	
	@OneToMany(mappedBy="academic")
	private List<Account> accounts = new ArrayList<>();
	
	public Academic() { }
	public Academic(String id) {
		setId(id);
	}
	public Academic(String id, String firstName, String middleName, String lastName) {
		this(id);
		setFirstName(firstName);
		setMiddleName(middleName);
		setLastName(lastName);
	}
	public Academic(String id, String firstName, String middleName, String lastName, AcademicType type) {
		this(id, firstName, middleName, lastName);
		setType(type);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public AcademicType getType() {
		return type;
	}
	public void setType(AcademicType type) {
		this.type = type;
	}
	
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	@Override
	public String toString() {
		return "Academic [id=" + getId() +
				", firstName=" + getFirstName() +
				", middleName=" + getMiddleName() +
				", lastName=" + getLastName() +
				", type=" + getType() +
				", accounts=" + getAccounts() + "]";
	}
}
