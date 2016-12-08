package com.niit.collaboration.service;

import java.util.List;

import com.niit.collaboration.model.Person;



public interface PersonDAO {
	
	   public List<Person> getAllPerson();
	   public  Person getPerson(int personid);
	   public void insertPerson(Person person);
	   public Person updatePerson(int id ,Person person);
	   public void deletePerson(int id);
	   public void deleteallPerson(Person person);
	  
}
