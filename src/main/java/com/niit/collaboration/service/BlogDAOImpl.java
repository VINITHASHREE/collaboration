package com.niit.collaboration.service;

import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.model.Blog;


public class BlogDAOImpl implements BlogDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	

	public SessionFactory getSession()
	{
		return sessionFactory;
	}
	
	public BlogDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory= sessionFactory; 
	}

	@Transactional
	public List<Blog> getAllBlog() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Blog");
		List<Blog> blog=query.list();
		session.close();
		return blog;
	}

	@Transactional
	public Blog getBlog(int blogid) {
		return(Blog)sessionFactory.getCurrentSession().get(Blog.class, blogid);
	}

	@Transactional
	public void insertBlog(Blog blog) {
		sessionFactory.getCurrentSession().saveOrUpdate(blog);

	}

	@Transactional
	public Blog updateBlog(int id, Blog blog) {
		Session session=sessionFactory.openSession();
		
		System.out.println("Id of Blog is " +blog.getBlogid());
		if(session.get(Blog.class, id)==null)
		return null;
		session.merge(blog); 
		
		Blog updatedBlog=(Blog)session.get(Blog.class, id); 
		session.flush();
		session.close();
		return updatedBlog;
	}

	@Transactional
	public void deleteBlog(int id) {
		Session session=sessionFactory.openSession();
		
		Blog blog=(Blog)session.get(Blog.class, id);
		session.delete(blog);
		
		session.flush();
		session.close();


	}

	@Transactional
	public void deleteallBlog(Blog blog) {
		// TODO Auto-generated method stub

	}

}
