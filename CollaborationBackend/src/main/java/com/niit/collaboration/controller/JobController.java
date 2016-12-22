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

import com.niit.collaboration.model.Job;
import com.niit.collaboration.service.JobDAO;


@Controller
public class JobController {
	
	@Autowired
	private JobDAO jobDAO;
	
	
	public JobDAO getJobDAO() {
		return jobDAO;
	}

	public void setJobDAO(JobDAO jobDAO) {
		this.jobDAO = jobDAO;
	}
	
	@RequestMapping(value="job",method=RequestMethod.GET)
	public  ResponseEntity<List<Job>> getAllJob(){
		
		System.out.println(jobDAO.getAllJob());
		
		List<Job> job=jobDAO.getAllJob();
		
		if(job.isEmpty())
			return new ResponseEntity<List<Job>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Job>>(job,HttpStatus.OK);
	}

	//http://localhost:8080/crudusingrest/person/2
	@RequestMapping(value="job/{id}",method=RequestMethod.GET)
	public ResponseEntity<Job> getJobById(@PathVariable(value="id") int id){
		Job job=jobDAO.getJob(id);
		if(job==null)
			return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Job>(job,HttpStatus.OK);
	}


	@RequestMapping(value="job",method=RequestMethod.POST)
	//RequestBody - to convert JSON data to java object
	//ResponseBody -> server to client
	//RequestBody -> client to server
	public ResponseEntity<Void> createJob(@RequestBody Job job){
	
		jobDAO.insertJob(job);
		/*UriComponentsBuilder build){
	     HttpHeaders headers=new HttpHeaders();
		//http://localhost:8080/appname/person/210
		java.net.URI urilocation=
				build.path("job/")
				.path(String.valueOf(job.getJobid()))
				.build()
				.toUri();
		headers.setLocation(urilocation);*/
		return new ResponseEntity(job,HttpStatus.CREATED);
	}

	@RequestMapping(value="job/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Job> updateJob(
			@PathVariable int id,@RequestBody Job job){
		
		Job updatedJob=jobDAO.updateJob(id, job);
		if(job==null)
			return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Job>(updatedJob,HttpStatus.OK);
		
		
	}
	@RequestMapping(value="job/{id}",method=RequestMethod.DELETE)
	
	public ResponseEntity<Void> deleteJob(@PathVariable int id){
		Job job=jobDAO.getJob(id);
		if(job==null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		jobDAO.deleteJob(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}




}
