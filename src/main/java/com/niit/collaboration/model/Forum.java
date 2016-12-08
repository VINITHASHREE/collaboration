package com.niit.collaboration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Forum")
public class Forum {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int fid;
	@Column
	private int userid;
	@Column
	private String title;
	@Column
	private String comment;
	@Column
	private String forumdate;
	
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getForumdate() {
		return forumdate;
	}
	public void setForumdate(String forumdate) {
		this.forumdate = forumdate;
	}
	
	

	
}
