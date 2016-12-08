package com.niit.collaboration.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.model.FriendList;

public class FriendListDAOImpl implements FriendListDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	

	public SessionFactory getSession()
	{
		return sessionFactory;
	}
	
	public FriendListDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory= sessionFactory; 
	}

	@Transactional
	public List<FriendList> getAllFriendList() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from FriendList");
		List<FriendList> friendlist=query.list();
		session.close();
		return friendlist;
	}

	@Transactional
	public FriendList getFriendList(int friendlistid) {
		return(FriendList)sessionFactory.getCurrentSession().get(FriendList.class, friendlistid);
	}

	@Transactional
	public void insertFriendList(FriendList friendlist) {
		sessionFactory.getCurrentSession().saveOrUpdate(friendlist);
	}

	@Transactional
	public FriendList updateFriendList(int id, FriendList friendlist) {
		Session session=sessionFactory.openSession();
		
		System.out.println("Id of Chat is " +friendlist.getFriendlistid());
		if(session.get(FriendList.class, id)==null)
		return null;
		session.merge(friendlist); 
		
		FriendList updatedFriendList=(FriendList)session.get(FriendList.class, id); 
		session.flush();
		session.close();
		return updatedFriendList;
	}

	@Transactional
	public void deleteFriendList(int id) {
		Session session=sessionFactory.openSession();
		
		FriendList friendlist=(FriendList)session.get(FriendList.class, id);
		session.delete(friendlist);
		
		session.flush();
		session.close();

	}

	@Transactional
	public void deleteallFriendList(FriendList friendlist) {
		// TODO Auto-generated method stub

	}

}
