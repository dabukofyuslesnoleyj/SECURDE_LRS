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
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "roomId")
	private Room room;
	
	private LocalDate date;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="reservationTimeRel", joinColumns=@JoinColumn(name="reservationId"), inverseJoinColumns=@JoinColumn(name="timeId"))  
	private List<TimeSlot> timeSlots;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "reserverId")
	private Account reserver;
	
	private String group;
	
	private String members;
	
	public RoomReservation() { }
	public RoomReservation(Room room, LocalDate date, List<TimeSlot> timeSlots) {
		this();
		setRoom(room);
		setDate(date);
		setTimeSlots(timeSlots);
	}
	public RoomReservation(Room room, LocalDate date, List<TimeSlot> timeSlots, Account reserver) {
		this(room, date, timeSlots);
		setReserver(reserver);
	}
	public RoomReservation(Room room, LocalDate date, List<TimeSlot> timeSlots, Account reserver, String group, String members) {
		this(room, date, timeSlots, reserver);
		this.group = group;
		this.members = members;
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
	
	public Account getReserver() {
		return reserver;
	}
	public void setReserver(Account reserver) {
		this.reserver = reserver;
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
}
