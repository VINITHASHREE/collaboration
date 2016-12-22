package com.niit.collaboration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="friendlist")
public class FriendList {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int friendlistid;
	@Column
	private String friendname;
	@Column
	private String email;
	@Column
	private Long mobilenumber;
	 
	public int getFriendlistid() {
		return  friendlistid;
	}
	public void setFriendlistid(int friendlistid) {
		this.friendlistid = friendlistid;
	}
	public String getFriendname() {
		return friendname;
	}
	public void setFriendname(String friendname) {
		this.friendname = friendname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(Long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	

}
