package com.niit.collaboration.service;

import java.util.List;

import com.niit.collaboration.model.Forum;

public interface ForumDAO {

	public List<Forum> getAllForum();
	   public  Forum getForum(int fid);
	   public void insertForum(Forum forum);
	   public Forum updateForum(int id ,Forum forum);
	   public void deleteForum(int id);
	   public void deleteallForum(Forum forum);
	
}
