package com.niit.collaboration.service;



import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import com.niit.collaboration.model.Person;



@Repository("PersonDAO")
public class PersonDAOImpl implements PersonDAO {

	@Autowired
	private SessionFactory sessionFactory;
	

	public SessionFactory getSession()
	{
		return sessionFactory;
	}
	
	public PersonDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory= sessionFactory; 
	}
	
	

	/*@Transactional
	public List<Person> getAllPersons() {
		return (List<Person>) sessionFactory.getCurrentSession().createQuery("from Person").list();
	}*/


	@Transactional
	public List<Person> getAllPerson() {
		
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Person");
		List<Person> person=query.list();
		session.close();
		return person;
	}
		
	@Transactional
	public Person getPerson(int personid) {
		return(Person)sessionFactory.getCurrentSession().get(Person.class, personid);
	
	
	}
	

	@Transactional
	public void insertPerson(Person person) {
		sessionFactory.getCurrentSession().saveOrUpdate(person);
	}

	
	
	@Transactional
	public Person updatePerson(int id, Person person) {
		Session session=sessionFactory.openSession();
		
		System.out.println("Id of Person is " +person.getPersonid());
		if(session.get(Person.class, id)==null)
		return null;
		session.merge(person); 
		
		Person updatedPerson=(Person)session.get(Person.class, id); 
		session.flush();
		session.close();
		return updatedPerson;
	}
	
	
	
	@Transactional
	public void deletePerson(int id) {
		Session session=sessionFactory.openSession();
		
		Person person=(Person)session.get(Person.class, id);
		session.delete(person);
		
		session.flush();
		session.close();

	}

	@Transactional
	public void deleteallPerson(Person person) {
		// TODO Auto-generated method stub

	}


	

}
