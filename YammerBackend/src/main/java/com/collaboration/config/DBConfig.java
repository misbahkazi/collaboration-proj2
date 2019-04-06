package com.collaboration.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.collaboration.model.Blog;
import com.collaboration.model.BlogComment;
import com.collaboration.model.Forum;
import com.collaboration.model.ForumComment;
import com.collaboration.model.Friend;
import com.collaboration.model.Job;
import com.collaboration.model.Message;
import com.collaboration.model.OutputMessage;
import com.collaboration.model.ProfilePicture;
import com.collaboration.model.UserDetail;

@Configuration
@ComponentScan("com.collaboration")
@EnableTransactionManagement
public class DBConfig 
{

	public DataSource getDataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("yammer");
		dataSource.setPassword("123456");
		System.out.println("--Created the DataSource -----");
		return dataSource;
	}
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties hibernateProp=new Properties();
		hibernateProp.put("hibernate.hbmddl2.auto", "update");
		hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		
		LocalSessionFactoryBuilder factoryBuilder=new LocalSessionFactoryBuilder(getDataSource());
		factoryBuilder.addProperties(hibernateProp);
		
		factoryBuilder.addAnnotatedClass(Blog.class);
		factoryBuilder.addAnnotatedClass(UserDetail.class);
		factoryBuilder.addAnnotatedClass(Job.class);
		factoryBuilder.addAnnotatedClass(BlogComment.class);
		factoryBuilder.addAnnotatedClass(ForumComment.class);
		factoryBuilder.addAnnotatedClass(Forum.class);
		factoryBuilder.addAnnotatedClass(Friend.class);
		factoryBuilder.addAnnotatedClass(Message.class);
		factoryBuilder.addAnnotatedClass(OutputMessage.class);
		factoryBuilder.addAnnotatedClass(ProfilePicture.class);
		
		
		SessionFactory sessionFactory=factoryBuilder.buildSessionFactory();
		System.out.println("--Created the sessionFactory -----");
		return sessionFactory;
	}
	
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("--Created the TranactionManager -----");
		return new HibernateTransactionManager(sessionFactory);
	}
}
