package com.niit.collaboration.service;

import java.util.List;

import com.niit.collaboration.model.Blog;

public interface BlogDAO {

	 public List<Blog> getAllBlog();
	   public  Blog getBlog(int blogid);
	   public void insertBlog(Blog blog);
	   public Blog updateBlog(int id ,Blog blog);
	   public void deleteBlog(int id);
	   public void deleteallBlog(Blog blog);
}
