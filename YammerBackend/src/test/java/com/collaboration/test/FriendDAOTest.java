package com.collaboration.test;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.collaboration.DAO.FriendDAO;

public class FriendDAOTest 
 {

static FriendDAO friendDAO;
	
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.collaboration");
		context.refresh();	
		friendDAO=(FriendDAO)context.getBean("friendDAO");
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
