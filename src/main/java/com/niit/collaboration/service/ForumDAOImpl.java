package com.niit.collaboration.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.niit.collaboration.model.Forum;

@Repository("ForumDAO")
public class ForumDAOImpl implements ForumDAO {

	@Autowired
	private SessionFactory sessionFactory;
	

	public SessionFactory getSession()
	{
		return sessionFactory;
	}
	
	public ForumDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory= sessionFactory; 
	}

	@Transactional
	public List<Forum> getAllForum() {
		
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Forum");
		List<Forum> forum=query.list();
		session.close();
		return forum;
	}
	
	
	@Transactional
	public Forum getForum(int fid) {
		return(Forum)sessionFactory.getCurrentSession().get(Forum.class, fid);
	}

	@Transactional
	public void insertForum(Forum forum) {
		sessionFactory.getCurrentSession().saveOrUpdate(forum);


	}

	@Transactional
	public Forum updateForum(int id, Forum forum) {
        Session session=sessionFactory.openSession();
		
		System.out.println("Id of Forum is " +forum.getFid());
		if(session.get(Forum.class, id)==null)
		return null;
		session.merge(forum); 
		
		Forum updatedForum=(Forum)session.get(Forum.class, id); 
		session.flush();
		session.close();
		return updatedForum;
	}
	
	
	@Transactional
	public void deleteForum(int id) {
		Session session=sessionFactory.openSession();
		
		Forum forum=(Forum)session.get(Forum.class, id);
		session.delete(forum);
		
		session.flush();
		session.close();
	}


	@Transactional
	public void deleteallForum(Forum forum) {
		// TODO Auto-generated method stub

	}

}
