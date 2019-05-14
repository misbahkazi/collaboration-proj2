package com.collaboration.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collaboration.DAO.BlogCommentDAO;
import com.collaboration.model.Blog;
import com.collaboration.model.BlogComment;
import com.collaboration.model.Job;



public class BlogCommentDAOTest {

static BlogCommentDAO blogCommentDAO;
	
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.collaboration");
		context.refresh();	
		blogCommentDAO=(BlogCommentDAO)context.getBean("blogCommentDAO");
	}

	//@Ignore
	@Test
	public void addBlogCommentTest() 
	{
		BlogComment blogComment=new BlogComment();
		blogComment.setBlogId(1038);
		blogComment.setCommentText("very helpful");
		blogComment.setCommentDate(new java.util.Date());
		blogComment.setUsername("jane");
		
		assertTrue("Problem in adding BlogComment",blogCommentDAO.addBlogComment(blogComment));
	
	}
	
	@Ignore
	//@Test
	public void deleteBlogCommentTest() 
	{
		BlogComment blogComment=blogCommentDAO.getBlogComment(953);
		assertTrue("Problem in deleting BlogComment",blogCommentDAO.deleteBlogComment(blogComment));
	}
	
	
}
