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

import com.niit.collaboration.model.Blog;
import com.niit.collaboration.service.BlogDAO;

@Controller
public class BlogController {
	

	@Autowired
	private BlogDAO blogDAO;
	
	
	public BlogDAO getBlogDAO() {
		return blogDAO;
	}

	public void setBlogDAO(BlogDAO blogDAO) {
		this.blogDAO = blogDAO;
	}
	
	@RequestMapping(value="blog",method=RequestMethod.GET)
	public  ResponseEntity<List<Blog>> getAllBlog(){
		
		System.out.println(blogDAO.getAllBlog());
		
		List<Blog> blog=blogDAO.getAllBlog();
		
		if(blog.isEmpty())
			return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Blog>>(blog,HttpStatus.OK);
	}

	//http://localhost:8080/crudusingrest/person/2
	@RequestMapping(value="blog/{id}",method=RequestMethod.GET)
	public ResponseEntity<Blog> getBlogById(@PathVariable(value="id") int id){
		Blog blog=blogDAO.getBlog(id);
		if(blog==null)
			return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	}


	@RequestMapping(value="blog",method=RequestMethod.POST)
	//RequestBody - to convert JSON data to java object
	//ResponseBody -> server to client
	//RequestBody -> client to server
	public ResponseEntity<Void> createBlog(@RequestBody Blog blog){
		blogDAO.insertBlog(blog);
			/*UriComponentsBuilder build){
		
		HttpHeaders headers=new HttpHeaders();
		//http://localhost:8080/appname/person/210
		java.net.URI urilocation=
				build.path("blog/")
				.path(String.valueOf(blog.getBlogid()))
				.build()
				.toUri();
		headers.setLocation(urilocation);*/
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(value="blog/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Blog> updateBlog(
			@PathVariable int id,@RequestBody Blog blog){
		
		Blog updatedBlog=blogDAO.updateBlog(id, blog);
		if(blog==null)
			return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Blog>(updatedBlog,HttpStatus.OK);
		
		
	}
	@RequestMapping(value="blog/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteBlog(@PathVariable int id){
		Blog blog=blogDAO.getBlog(id);
		if(blog==null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		blogDAO.deleteBlog(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}



}
