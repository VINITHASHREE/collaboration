package com.niit.collaboration.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.model.Blog;
import com.niit.collaboration.model.Event;

public class EventDAOImpl implements EventDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	

	public SessionFactory getSession()
	{
		return sessionFactory;
	}
	
	public EventDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory= sessionFactory; 
	}

	@Transactional
	public List<Event> getAllEvent() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Event");
		List<Event> event=query.list();
		session.close();
		return event;
	}

	@Transactional
	public Event getEvent(int eventid) {
		return(Event)sessionFactory.getCurrentSession().get(Event.class, eventid);
	}

	@Transactional
	public void insertEvent(Event event) {
		sessionFactory.getCurrentSession().saveOrUpdate(event);

	}

	@Transactional
	public Event updateEvent(int id, Event event) {
		Session session=sessionFactory.openSession();
		
		System.out.println("Id of Event is " +event.getEventid());
		if(session.get(Event.class, id)==null)
		return null;
		session.merge(event); 
		
		Event updatedEvent=(Event)session.get(Event.class, id); 
		session.flush();
		session.close();
		return updatedEvent;
	}

	@Transactional
	public void deleteEvent(int id) {
		Session session=sessionFactory.openSession();
		
		Event event=(Event)session.get(Event.class, id);
		session.delete(event);
		
		session.flush();
		session.close();

	}

	@Transactional
	public void deleteallEvent(Event event) {
		// TODO Auto-generated method stub

	}

}
