package com.niit.collaboration.service;

import java.util.List;

import com.niit.collaboration.model.FriendList;



public interface FriendListDAO {

	 public List<FriendList> getAllFriendList();
	   public  FriendList getFriendList(int  friendlistid);
	   public void insertFriendList(FriendList  friendlist);
	   public FriendList updateFriendList(int id ,FriendList  friendlist);
	   public void deleteFriendList(int id);
	   public void deleteallFriendList(FriendList  friendlist);
}
