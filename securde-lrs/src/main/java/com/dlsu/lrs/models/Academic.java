package com.dlsu.lrs.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.dlsu.lrs.Jsonifiable;

@Entity
public class Academic implements Jsonifiable {

	@Id
	private String id;
	private String firstName;
	private String middleName;
	private String lastName;
	private AcademicType type = AcademicType.STUDENT;
	
	public Academic() { }
	public Academic(String id) {
		this.id = id;
	}
	public Academic(String id, String firstName, String middleName, String lastName) {
		this(id);
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}
	public Academic(String id, String firstName, String middleName, String lastName, AcademicType type) {
		this(id, firstName, middleName, lastName);
		this.type = type;
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
	
	@Override
	public String toString() {
		return "Academic [id=" + id +
				", firstName=" + firstName +
				", middleName=" + middleName +
				", lastName=" + lastName +
				", type=" + type + "]";
	}
}
