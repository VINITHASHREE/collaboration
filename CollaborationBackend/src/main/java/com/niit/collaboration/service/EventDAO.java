package com.niit.collaboration.service;

import java.util.List;

import com.niit.collaboration.model.Event;

public interface EventDAO {
	
	 public List<Event> getAllEvent();
	   public  Event getEvent(int eventid);
	   public void insertEvent(Event event);
	   public Event updateEvent(int id ,Event event);
	   public void deleteEvent(int id);
	   public void deleteallEvent(Event event);

}
