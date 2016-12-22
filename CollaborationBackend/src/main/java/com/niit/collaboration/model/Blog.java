package com.niit.collaboration.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="blog")
public class Blog {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int blogid;
	@Column
	private String blogname;
	@Column
	private String blogcontent;
	@Column
	private  Date blogdate;
	
	public int getBlogid() {
		return blogid;
	}
	public void setBlogid(int blogid) {
		this.blogid = blogid;
	}
	public String getBlogname() {
		return blogname;
	}
	public void setBlogname(String blogname) {
		this.blogname = blogname;
	}
	public String getBlogcontent() {
		return blogcontent;
	}
	public void setBlogcontent(String blogcontent) {
		this.blogcontent = blogcontent;
	}
	public Date getBlogdate() {
		return blogdate;
	}
	public void setBlogdate(Date blogdate) {
		this.blogdate = blogdate;
	}
}
