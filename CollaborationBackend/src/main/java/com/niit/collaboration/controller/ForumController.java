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

import com.niit.collaboration.model.Forum;
import com.niit.collaboration.service.ForumDAO;

@Controller
public class ForumController {
	@Autowired
	private ForumDAO forumDAO;
	
	public ForumDAO getForumDAO() {
		return forumDAO;
	}

	public void setForumDAO(ForumDAO forumDAO) {
		this.forumDAO = forumDAO;
	}
	
	
	@RequestMapping(value="forum",method=RequestMethod.GET)
	public  ResponseEntity<List<Forum>> getAllForum(){
		
		System.out.println(forumDAO.getAllForum());
		
		List<Forum> forum=forumDAO.getAllForum();
		
		if(forum.isEmpty())
			return new ResponseEntity<List<Forum>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Forum>>(forum,HttpStatus.OK);
	}

	//http://localhost:8080/crudusingrest/person/2
	@RequestMapping(value="forum/{id}",method=RequestMethod.GET)
	public ResponseEntity<Forum> getForumById(@PathVariable(value="id") int id){
		Forum forum=forumDAO.getForum(id);
		if(forum==null)
			return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Forum>(forum,HttpStatus.OK);
	}


	@RequestMapping(value="forum",method=RequestMethod.POST)
	//RequestBody - to convert JSON data to java object
	//ResponseBody -> server to client
	//RequestBody -> client to server
	public ResponseEntity<Void> createForum(@RequestBody Forum forum){
		forumDAO.insertForum(forum);
			/*UriComponentsBuilder build){
		
		HttpHeaders headers=new HttpHeaders();
		//http://localhost:8080/appname/person/210
		java.net.URI urilocation=
				build.path("forum/")
				.path(String.valueOf(forum.getForumid()))
				.build()
				.toUri();
		headers.setLocation(urilocation);*/
		return new ResponseEntity(HttpStatus.CREATED);
	}

	@RequestMapping(value="forum/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Forum> updateForum(
			@PathVariable int id,@RequestBody Forum forum){
		
		Forum updatedForum=forumDAO.updateForum(id, forum);
		if(forum==null)
			return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Forum>(updatedForum,HttpStatus.OK);
		
		
	}
	@RequestMapping(value="forum/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteForum(@PathVariable int id){
		Forum forum=forumDAO.getForum(id);
		if(forum==null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		forumDAO.deleteForum(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}





}
