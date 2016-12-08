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

import com.niit.collaboration.model.Person;
import com.niit.collaboration.service.PersonDAO;


@Controller
public class PersonController {
	
	
	@Autowired
	private PersonDAO personDAO;
	
	
	public PersonDAO getPersonDAO() {
		return personDAO;
	}

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}
	
	
	

	@RequestMapping(value="person",method=RequestMethod.GET)
	public  ResponseEntity<List<Person>> getAllPersons(){
		
		System.out.println(personDAO.getAllPerson());
		
		List<Person> persons=personDAO.getAllPerson();
		
		if(persons.isEmpty())
			return new ResponseEntity<List<Person>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Person>>(persons,HttpStatus.OK);
	}

	//http://localhost:8080/crudusingrest/person/2
	@RequestMapping(value="person/{id}",method=RequestMethod.GET)
	public ResponseEntity<Person> getPersonById(@PathVariable(value="id") int id){
		Person person=personDAO.getPerson(id);
		if(person==null)
			return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Person>(person,HttpStatus.OK);
	}


	@RequestMapping(value="person",method=RequestMethod.POST)
	//RequestBody - to convert JSON data to java object
	//ResponseBody -> servet to client
	//RequestBody -> client to server
	public ResponseEntity<Void> createPerson(@RequestBody Person person,
			UriComponentsBuilder build){
		//personDAO.savePerson(person);
		HttpHeaders headers=new HttpHeaders();
		//http://localhost:8080/appname/person/210
		java.net.URI urilocation=
				build.path("person/")
				.path(String.valueOf(person.getPersonid()))
				.build()
				.toUri();
		headers.setLocation(urilocation);
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}

	@RequestMapping(value="person/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Person> updatePerson(
			@PathVariable int id,@RequestBody Person person){
		
		Person updatedPerson=personDAO.updatePerson(id, person);
		if(person==null)
			return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Person>(updatedPerson,HttpStatus.OK);
		
		
	}
	@RequestMapping(value="person/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> deletePerson(@PathVariable int id){
		Person person=personDAO.getPerson(id);
		if(person==null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		personDAO.deletePerson(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
