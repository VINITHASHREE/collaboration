package com.niit.collaboration.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="event")
public class Event {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int eventid;
	@Column
	private String eventname;
	@Column
	private String eventcontent;
	@Column
	private String  eventdetails;
	@Column
	private Date eventdate;
	public int getEventid() {
		return eventid;
	}
	public void setEventid(int eventid) {
		this.eventid = eventid;
	}
	public String getEventname() {
		return eventname;
	}
	public void setEventname(String eventname) {
		this.eventname = eventname;
	}
	public String getEventcontent() {
		return eventcontent;
	}
	public void setEventcontent(String eventcontent) {
		this.eventcontent = eventcontent;
	}
	public String getEventdetails() {
		return eventdetails;
	}
	public void setEventdetails(String eventdetails) {
		this.eventdetails = eventdetails;
	}
	public Date getEventdate() {
		return eventdate;
	}
	public void setEventdate(Date eventdate) {
		this.eventdate = eventdate;
	}
	

}
