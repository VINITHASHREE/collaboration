package com.niit.collaboration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.niit.collaboration.model.Event;
import com.niit.collaboration.service.EventDAO;

@Controller
public class EventController {
	
	@Autowired
	private EventDAO eventDAO;
	
	
	public EventDAO getEventDAO() {
		return eventDAO;
	}

	public void setEventDAO(EventDAO eventDAO) {
		this.eventDAO = eventDAO;
	}
	
	@RequestMapping(value="event",method=RequestMethod.GET)
	public  ResponseEntity<List<Event>> getAllEvent(){
		
		System.out.println(eventDAO.getAllEvent());
		
		List<Event> event=eventDAO.getAllEvent();
		
		if(event.isEmpty())
			return new ResponseEntity<List<Event>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Event>>(event,HttpStatus.OK);
	}

	//http://localhost:8080/crudusingrest/person/2
	@RequestMapping(value="event/{id}",method=RequestMethod.GET)
	public ResponseEntity<Event> getEventById(@PathVariable(value="id") int id){
		Event event=eventDAO.getEvent(id);
		if(event==null)
			return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Event>(event,HttpStatus.OK);
	}


	@RequestMapping(value="event",method=RequestMethod.POST)
	//RequestBody - to convert JSON data to java object
	//ResponseBody -> server to client
	//RequestBody -> client to server
	public ResponseEntity<Void> createEvent(@RequestBody Event event,
			UriComponentsBuilder build){
	
		HttpHeaders headers=new HttpHeaders();
		//http://localhost:8080/appname/person/210
		java.net.URI urilocation=
				build.path("event/")
				.path(String.valueOf(event.getEventid()))
				.build()
				.toUri();
		headers.setLocation(urilocation);
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}

	@RequestMapping(value="event/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Event> updateEvent(
			@PathVariable int id,@RequestBody Event event){
		
		Event updatedEvent=eventDAO.updateEvent(id, event);
		if(event==null)
			return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Event>(updatedEvent,HttpStatus.OK);
		
		
	}
	@RequestMapping(value="event/{id}",method=RequestMethod.DELETE)
	
	public ResponseEntity<Void> deleteEvent(@PathVariable int id){
		Event event=eventDAO.getEvent(id);
		if(event==null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		eventDAO.deleteEvent(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}



}
