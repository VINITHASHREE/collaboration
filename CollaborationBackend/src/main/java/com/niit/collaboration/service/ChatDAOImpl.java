package com.niit.collaboration.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.niit.collaboration.model.Chat;



@Repository("ChatDAO")
public class ChatDAOImpl implements ChatDAO {

	
	
	@Autowired
	private SessionFactory sessionFactory;
	

	public SessionFactory getSession()
	{
		return sessionFactory;
	}
	
	public ChatDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory= sessionFactory; 
	}

	@Transactional
	public List<Chat> getAllChat() {
		
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Chat");
		List<Chat> chat=query.list();
		session.close();
		return chat;
	}
	
	
	
	@Transactional
	public Chat getChat(int chatid) {
		return(Chat)sessionFactory.getCurrentSession().get(Chat.class, chatid);
	}

	@Transactional
	public void insertChat(Chat chat) {
		sessionFactory.getCurrentSession().saveOrUpdate(chat);

	}

	@Transactional
	public Chat updateChat(int id, Chat chat) {
Session session=sessionFactory.openSession();
		
		System.out.println("Id of Chat is " +chat.getChatid());
		if(session.get(Chat.class, id)==null)
		return null;
		session.merge(chat); 
		
		Chat updatedChat=(Chat)session.get(Chat.class, id); 
		session.flush();
		session.close();
		return updatedChat;
	}
	
	
	@Transactional
	public void deleteChat(int id) {
		Session session=sessionFactory.openSession();
		
		Chat chat=(Chat)session.get(Chat.class, id);
		session.delete(chat);
		
		session.flush();
		session.close();
	}

	@Transactional
	public void deleteallChat(Chat chat) {
		// TODO Auto-generated method stub

	}

}
