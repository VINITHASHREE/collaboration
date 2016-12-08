package com.niit.collaboration.service;

import java.util.List;

import com.niit.collaboration.model.Job;

public interface JobDAO {
	 public List<Job> getAllJob();
	   public  Job getJob(int jobid);
	   public void insertJob(Job job);
	   public Job updateJob(int id ,Job job);
	   public void deleteJob(int id);
	   public void deleteallJob(Job job);

}
