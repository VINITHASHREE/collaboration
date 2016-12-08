package com.niit.collaboration.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.model.Job;

public class JobDAOImpl implements JobDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	

	public SessionFactory getSession()
	{
		return sessionFactory;
	}
	
	public JobDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory= sessionFactory; 
	}
	
	@Transactional
	public List<Job> getAllJob() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Job");
		List<Job> job=query.list();
		session.close();
		return job;
	}

	@Transactional
	public Job getJob(int jobid) {
		return(Job)sessionFactory.getCurrentSession().get(Job.class, jobid);

	}

	@Transactional
	public void insertJob(Job job) {
		sessionFactory.getCurrentSession().saveOrUpdate(job);

	}

	@Transactional
	public Job updateJob(int id, Job job) {
		Session session=sessionFactory.openSession();
		
		System.out.println("Id of Job is " +job.getJobid());
		if(session.get(Job.class, id)==null)
		return null;
		session.merge(job); 
		
		Job updatedJob=(Job)session.get(Job.class, id); 
		session.flush();
		session.close();
		return updatedJob;
	}

	@Transactional
	public void deleteJob(int id) {
		Session session=sessionFactory.openSession();
		
		Job job=(Job)session.get(Job.class, id);
		session.delete(job);
		
		session.flush();
		session.close();


	}

	@Transactional
	public void deleteallJob(Job job) {
		// TODO Auto-generated method stub

	}

}
