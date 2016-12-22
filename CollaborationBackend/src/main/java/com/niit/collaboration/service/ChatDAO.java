package com.niit.collaboration.service;

import java.util.List;


import com.niit.collaboration.model.Chat;

public interface ChatDAO {

	public List<Chat> getAllChat();
	   public  Chat getChat(int chatid);
	   public void insertChat(Chat chat);
	   public Chat updateChat(int id ,Chat chat);
	   public void deleteChat(int id);
	   public void deleteallChat(Chat chat);
	   
	
}
