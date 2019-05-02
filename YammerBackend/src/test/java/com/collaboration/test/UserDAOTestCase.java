package com.collaboration.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.collaboration.DAO.UserDAO;
import com.collaboration.model.UserDetail;

public class UserDAOTestCase {

	static UserDAO userDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.collaboration");
		context.refresh();	
		userDAO=(UserDAO)context.getBean("userDAO");
	}

	@Ignore
	//@Test
	public void registerUserTest() 
	{
		UserDetail user=new UserDetail();
		user.setCustomerName("jane k");
		user.setUsername("jane");
		user.setPassword("123");
		user.setEmailId("jane@gmail.com");
		user.setIsOnline("ON");
		user.setRole("student");
		user.setStatus("A");
		
		assertTrue("Problem in adding User",userDAO.registerUser(user));
		
		
	}

	//@Ignore
	@Test
	public void updateUserTest()
	{
		UserDetail user=userDAO.getUser("jane");
		user.setCustomerName("jane R");
		assertTrue("Problem in Updating the User",userDAO.updateUserDetail(user));
	}
	
	
}
