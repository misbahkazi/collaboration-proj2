package com.collaboration.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.collaboration.DAO.ForumCommentDAO;
import com.collaboration.model.BlogComment;
import com.collaboration.model.ForumComment;




public class ForumCommentDAOTest {

static ForumCommentDAO forumCommentDAO;
	
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.collaboration");
		context.refresh();	
		forumCommentDAO=(ForumCommentDAO)context.getBean("forumCommentDAO");
	}

	@Ignore
	//@Test
	public void addForumCommentTest() 
	{
		ForumComment forumComment=new ForumComment();
		forumComment.setForumId(952);
		forumComment.setCommentText("nice");
		forumComment.setCommentDate(new java.util.Date());
		forumComment.setUsername("jane");
		
		assertTrue("Problem in adding ForumComment",forumCommentDAO.addForumComment(forumComment));
	
	}
	
	@Ignore
	//@Test
	public void deleteForumCommentTest() 
	{
		ForumComment forumComment=forumCommentDAO.getForumComment(953);
		assertTrue("Problem in deleting ForumComment",forumCommentDAO.deleteForumComment(forumComment));
	}
}
	
	