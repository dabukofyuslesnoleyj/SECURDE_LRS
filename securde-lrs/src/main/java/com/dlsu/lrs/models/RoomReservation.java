package com.dlsu.lrs.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class RoomReservation {

	@Id @GeneratedValue
	private long id;
	
	private LocalDateTime timestamp;
	
	private String group;
	
	private String members;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "reserverId")
	private Account reserver;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "roomId")
	private Room room;
	
	private LocalDate date;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="reservationTimeRel", joinColumns=@JoinColumn(name="reservationId"), inverseJoinColumns=@JoinColumn(name="timeId"))  
	private List<TimeSlot> timeSlots;
	
	public RoomReservation() {
		this.timestamp = LocalDateTime.now();
	}
	public RoomReservation(String group, String members, Account reserver, Room room, LocalDate date, List<TimeSlot> timeSlots) {
		this.timestamp = LocalDateTime.now();
		this.group = group;
		this.members = members;
		this.reserver = reserver;
		this.room = room;
		this.date = date;
		this.timeSlots = timeSlots;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	
	public String getMembers() {
		return members;
	}
	public void setMembers(String members) {
		this.members = members;
	}

	public Account getReserver() {
		return reserver;
	}
	public void setReserver(Account reserver) {
		this.reserver = reserver;
	}
	
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List<TimeSlot> getTimeSlots() {
		return timeSlots;
	}
	public void setTimeSlots(List<TimeSlot> timeSlots) {
		this.timeSlots = timeSlots;
	}
}
