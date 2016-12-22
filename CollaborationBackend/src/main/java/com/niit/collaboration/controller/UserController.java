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

import com.niit.collaboration.model.User;
import com.niit.collaboration.service.UserDAO;


@Controller
public class UserController {
	
	
	@Autowired
	private UserDAO userDAO;
	
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	
	

	@RequestMapping(value="user",method=RequestMethod.GET)
	public  ResponseEntity<List<User>> getAllUser(){
		
		System.out.println(userDAO.getAllUser());
		
		List<User> user=userDAO.getAllUser();
		
		if(user.isEmpty())
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<User>>(user,HttpStatus.OK);
	}

	//http://localhost:8080/crudusingrest/user/2
	@RequestMapping(value="user/{id}",method=RequestMethod.GET)
	public ResponseEntity<User> getUserById(@PathVariable(value="id") int id){
		User user=userDAO.getUser(id);
		if(user==null)
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}


	@RequestMapping(value="user",method=RequestMethod.POST)
	//RequestBody - to convert JSON data to java object
	//ResponseBody -> server to client
	//RequestBody -> client to server
	public ResponseEntity createUser(@RequestBody User user){
		//personDAO.savePerson(person);
		userDAO.insertUser(user);
		/*HttpHeaders headers=new HttpHeaders();
		//http://localhost:8080/appname/person/210
		java.net.URI urilocation=
				build.path("user/")
				.path(String.valueOf(user.getUserid()))
				.build()
				.toUri();
		headers.setLocation(urilocation);*/
		return new ResponseEntity(user,HttpStatus.CREATED);
	}

	@RequestMapping(value="user/{id}",method=RequestMethod.PUT)
	public ResponseEntity<User> updateUser(
			@PathVariable int id,@RequestBody User user){
		
		User updatedUser=userDAO.updateUser(id, user);
		if(user==null)
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<User>(updatedUser,HttpStatus.OK);
		
		
	}
	@RequestMapping(value="user/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUser(@PathVariable int id){
		User user=userDAO.getUser(id);
		if(user==null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		userDAO.deleteUser(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
