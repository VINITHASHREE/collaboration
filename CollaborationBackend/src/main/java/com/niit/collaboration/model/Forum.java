package com.niit.collaboration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="forum")

public class Forum {
	

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int forumid;
	@Column
	private String username;
	@Column
	private String forumtitle;
	@Column
	private String forumcomment;
	@Column
	private String forumdate;
	public int getForumid() {
		return forumid;
	}
	public void setForumid(int forumid) {
		this.forumid = forumid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getForumtitle() {
		return forumtitle;
	}
	public void setForumtitle(String forumtitle) {
		this.forumtitle = forumtitle;
	}
	public String getForumcomment() {
		return forumcomment;
	}
	public void setForumcomment(String forumcomment) {
		this.forumcomment = forumcomment;
	}
	public String getForumdate() {
		return forumdate;
	}
	public void setForumdate(String forumdate) {
		this.forumdate = forumdate;
	}
	
	
	
	
	
	
	

}
