package com.system.management.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class Ticket {
	public Ticket(){
		
	}
	private int ticketid;
	private String ticketName;
	private String singer;
	private Date day;
	private String time;
	private String kind;
	private float price;
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	private String place;
	private Set<Seat> seat=new HashSet<>();
	public Set<Seat> getSeat() {
		return seat;
	}
	public void setSeat(Set<Seat> seat) {
		this.seat = seat;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int getTicketid() {
		return ticketid;
	}
	public void setTicketid(int ticketid) {
		this.ticketid = ticketid;
	}
	public String getTicketName() {
		return ticketName;
	}
	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}

	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

}
