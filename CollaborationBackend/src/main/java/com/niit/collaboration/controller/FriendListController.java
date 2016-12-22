package com.niit.collaboration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.niit.collaboration.model.FriendList;
import com.niit.collaboration.service.FriendListDAO;



public class FriendListController {
	
	@Autowired
	private FriendListDAO friendListDAO;
	
	
	public FriendListDAO getFriendListDAO() {
		return friendListDAO;
	}

	public void setFriendListDAO(FriendListDAO friendListDAO) {
		this.friendListDAO = friendListDAO;
	}
	
	@RequestMapping(value="friendList",method=RequestMethod.GET)
	public  ResponseEntity<List<FriendList>> getAllJob(){
		
		System.out.println(friendListDAO.getAllFriendList());
		
		List<FriendList> friendList=friendListDAO.getAllFriendList();
		
		if(friendList.isEmpty())
			return new ResponseEntity<List<FriendList>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<FriendList>>(friendList,HttpStatus.OK);
	}

	//http://localhost:8080/crudusingrest/person/2
	@RequestMapping(value="friendList/{id}",method=RequestMethod.GET)
	public ResponseEntity<FriendList> getJobById(@PathVariable(value="id") int id){
		FriendList friendList=friendListDAO.getFriendList(id);
		if(friendList==null)
			return new ResponseEntity<FriendList>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<FriendList>(friendList,HttpStatus.OK);
	}


	@RequestMapping(value="friendList",method=RequestMethod.POST)
	//RequestBody - to convert JSON data to java object
	//ResponseBody -> server to client
	//RequestBody -> client to server
	public ResponseEntity<Void> createFriendList(@RequestBody FriendList friendList,
			UriComponentsBuilder build){
	
		HttpHeaders headers=new HttpHeaders();
		//http://localhost:8080/appname/person/210
		java.net.URI urilocation=
				build.path("friendList/")
				.path(String.valueOf(friendList.getFriendlistid()))
				.build()
				.toUri();
		headers.setLocation(urilocation);
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}

	@RequestMapping(value="friendList/{id}",method=RequestMethod.PUT)
	public ResponseEntity<FriendList> updateFriendList(
			@PathVariable int id,@RequestBody FriendList friendList){
		
		FriendList updatedFriendList=friendListDAO.updateFriendList(id, friendList);
		if(friendList==null)
			return new ResponseEntity<FriendList>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<FriendList>(updatedFriendList,HttpStatus.OK);
		
		
	}
	@RequestMapping(value="friendList/{id}",method=RequestMethod.DELETE)
	
	public ResponseEntity<Void> deleteFriendList(@PathVariable int id){
		FriendList friendList=friendListDAO.getFriendList(id);
		if(friendList==null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		friendListDAO.deleteFriendList(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}





}
