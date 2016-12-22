package com.niit.collaboration.service;



import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import com.niit.collaboration.model.User;



@Repository("UserDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	

	public SessionFactory getSession()
	{
		return sessionFactory;
	}
	
	public UserDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory= sessionFactory; 
	}
	
	

	/*@Transactional
	public List<Person> getAllPersons() {
		return (List<Person>) sessionFactory.getCurrentSession().createQuery("from Person").list();
	}*/


	@Transactional
	public List<User> getAllUser() {
		
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from User");
		List<User> user=query.list();
		session.close();
		return user;
	}
		
	@Transactional
	public User getUser(int userid) {
		return(User)sessionFactory.getCurrentSession().get(User.class, userid);
	
	
	}
	

	@Transactional
	public void insertUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	
	
	@Transactional
	public User updateUser(int id, User user) {
		Session session=sessionFactory.openSession();
		
		System.out.println("Id of User is " +user.getUserid());
		if(session.get(User.class, id)==null)
		return null;
		session.merge(user); 
		
		User updatedUser=(User)session.get(User.class, id); 
		session.flush();
		session.close();
		return updatedUser;
	}
	
	
	
	@Transactional
	public void deleteUser(int id) {
		Session session=sessionFactory.openSession();
		
		User user=(User)session.get(User.class, id);
		session.delete(user);
		
		session.flush();
		session.close();

	}

	@Transactional
	public void deleteallUser(User user) {
		// TODO Auto-generated method stub

	}


	

}
