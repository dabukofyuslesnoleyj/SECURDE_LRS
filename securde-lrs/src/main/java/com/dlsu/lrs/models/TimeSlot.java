package com.dlsu.lrs.models;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.dlsu.lrs.util.Jsonifiable;

@Entity
public class TimeSlot implements Jsonifiable {

	@Id @GeneratedValue
	private long id;
	
	private LocalTime start;
	private LocalTime end;
	
	public TimeSlot() { }
	public TimeSlot(LocalTime start, LocalTime end) {
		this();
		setStart(start);
		setEnd(end);
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public LocalTime getStart() {
		return start;
	}
	public void setStart(LocalTime start) {
		this.start = start;
	}

	public LocalTime getEnd() {
		return end;
	}
	public void setEnd(LocalTime end) {
		this.end = end;
	}
	@Override
	public String toString() {
		return "TimeSlot [id=" + getId() +
				", start=" + getStart() +
				", end=" + getEnd() + "]";
	}
}
