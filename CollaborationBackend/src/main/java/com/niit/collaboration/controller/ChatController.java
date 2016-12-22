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

import com.niit.collaboration.model.Chat;
import com.niit.collaboration.service.ChatDAO;

@Controller
public class ChatController {

	@Autowired
	private ChatDAO chatDAO;
	
	
	public ChatDAO getChatDAO() {
		return chatDAO;
	}

	public void setChatDAO(ChatDAO chatDAO) {
		this.chatDAO = chatDAO;
	}
	
	
	@RequestMapping(value="chat",method=RequestMethod.GET)
	public  ResponseEntity<List<Chat>> getAllChat(){
		
		System.out.println(chatDAO.getAllChat());
		
		List<Chat> chat=chatDAO.getAllChat();
		
		if(chat.isEmpty())
			return new ResponseEntity<List<Chat>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Chat>>(chat,HttpStatus.OK);
	}

	//http://localhost:8080/crudusingrest/person/2
	@RequestMapping(value="chat/{id}",method=RequestMethod.GET)
	public ResponseEntity<Chat> getChatById(@PathVariable(value="id") int id){
		Chat chat=chatDAO.getChat(id);
		if(chat==null)
			return new ResponseEntity<Chat>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Chat>(chat,HttpStatus.OK);
	}


	@RequestMapping(value="chat",method=RequestMethod.POST)
	//RequestBody - to convert JSON data to java object
	//ResponseBody -> server to client
	//RequestBody -> client to server
	public ResponseEntity<Void> createChat(@RequestBody Chat chat,
			UriComponentsBuilder build){

		HttpHeaders headers=new HttpHeaders();
		//http://localhost:8080/appname/person/210
		java.net.URI urilocation=
				build.path("chat/")
				.path(String.valueOf(chat.getChatid()))
				.build()
				.toUri();
		headers.setLocation(urilocation);
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}

	@RequestMapping(value="chat/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Chat> updateChat(
			@PathVariable int id,@RequestBody Chat chat){
		
		Chat updatedChat=chatDAO.updateChat(id, chat);
		if(chat==null)
			return new ResponseEntity<Chat>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Chat>(updatedChat,HttpStatus.OK);
		
		
	}
	@RequestMapping(value="chat/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteBlog(@PathVariable int id){
		Chat chat=chatDAO.getChat(id);
		if(chat==null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		chatDAO.deleteChat(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}


	
}

