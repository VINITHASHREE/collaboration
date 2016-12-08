package com.niit.collaboration.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.collaboration.model.Blog;
import com.niit.collaboration.model.Chat;
import com.niit.collaboration.model.Event;
import com.niit.collaboration.model.Forum;
import com.niit.collaboration.model.FriendList;
import com.niit.collaboration.model.Job;
import com.niit.collaboration.model.Person;
import com.niit.collaboration.service.BlogDAOImpl;
import com.niit.collaboration.service.ChatDAOImpl;
import com.niit.collaboration.service.EventDAOImpl;
import com.niit.collaboration.service.ForumDAOImpl;
import com.niit.collaboration.service.FriendListDAOImpl;
import com.niit.collaboration.service.JobDAOImpl;
import com.niit.collaboration.service.PersonDAOImpl;




@Configuration
@ComponentScan("com.niit.collaboration.*")
@EnableTransactionManagement
public class DBConfig {
	
	@Autowired
	@Bean(name="datasource")
	public DataSource getDataSource() {
	   DriverManagerDataSource dataSource=new DriverManagerDataSource();
	    dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
	    dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	    dataSource.setUsername("COLLABORATION");
	    dataSource.setPassword("niit");
		return dataSource;
			
	    
	}

	private Properties getHibernateProperties()
	{
		Properties properties=new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		
		properties.put("hibernate.format_sql","true");
		    return properties;
	}

	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder=new LocalSessionFactoryBuilder(dataSource);
		  sessionBuilder.addProperties(getHibernateProperties());
		  
		  sessionBuilder.addAnnotatedClass(Person.class);
		  sessionBuilder.addAnnotatedClass(Blog.class);
		  sessionBuilder.addAnnotatedClass(Chat.class);
		  sessionBuilder.addAnnotatedClass(Event.class);
		  sessionBuilder.addAnnotatedClass(FriendList.class);
		  sessionBuilder.addAnnotatedClass(Forum.class); 
		  sessionBuilder.addAnnotatedClass(Job.class);
		   return sessionBuilder.buildSessionFactory();
		   
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transcationManager=new HibernateTransactionManager(sessionFactory);
		return transcationManager;
	}
	
	
	  @Autowired(required=true)  
	    @Bean(name="personDAO")
	    public PersonDAOImpl getPersonDAO(SessionFactory sessionFactory) {
		      return new PersonDAOImpl(sessionFactory);
	    }
	  @Autowired(required=true)  
	    @Bean(name="blogDAO")
	    public BlogDAOImpl getBlogDAO(SessionFactory sessionFactory) {
		      return new BlogDAOImpl(sessionFactory);
	    }
	  @Autowired(required=true)  
	    @Bean(name="chatDAO")
	    public ChatDAOImpl getChatDAO(SessionFactory sessionFactory) {
		      return new ChatDAOImpl(sessionFactory);
	    }
	  @Autowired(required=true)  
	    @Bean(name="eventDAO")
	    public EventDAOImpl getEventDAO(SessionFactory sessionFactory) {
		      return new EventDAOImpl(sessionFactory);
	    }
	  @Autowired(required=true)  
	    @Bean(name="friendlistDAO")
	    public FriendListDAOImpl getFriendListDAO(SessionFactory sessionFactory) {
		      return new FriendListDAOImpl(sessionFactory);
	    }
	   @Autowired(required=true)  
	    @Bean(name="forumDAO")
	    public ForumDAOImpl getForumDAO(SessionFactory sessionFactory) {
		      return new ForumDAOImpl(sessionFactory);
	    }
	  @Autowired(required=true)  
	    @Bean(name="jobDAO")
	    public JobDAOImpl getJobDAO(SessionFactory sessionFactory) {
		      return new JobDAOImpl(sessionFactory);
	    }
		}




