package com.collaboration.test;

import static org.junit.Assert.assertTrue;



import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collaboration.DAO.ForumDAO;
import com.collaboration.model.Forum;





public class ForumDAOTest {
	
	
	static ForumDAO forumDAO;
	
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.collaboration");
		context.refresh();	
		forumDAO=(ForumDAO)context.getBean("forumDAO");
	}

	//@Ignore
	@Test
	public void addForumTest() 
	{
		Forum forum=new Forum();
		forum.setForumName("python");
		forum.setForumContent("python tutorials");
		forum.setCreateDate(new java.util.Date());
		forum.setStatus("NA");
		forum.setUsername("abc");
		assertTrue("Problem in adding forum",forumDAO.addForum(forum));
	}
	
	@Ignore
	@Test
	public void updateForumTest() 
	{
		Forum forum=forumDAO.getForum(953);
		forum.setForumContent("Adv java");
		assertTrue("Problem in updating Forum",forumDAO.updateForum(forum));
	}
	
	
	@Ignore
	@Test
	public void deleteForumTest() 
	{
		Forum forum=forumDAO.getForum(953);
		assertTrue("Problem in deleting Forum",forumDAO.deleteForum(forum));
	}
	
	
	@Ignore
	@Test
	public void listForumTest() 
	{
		
		List<Forum> listForums=forumDAO.getAllForums();
		assertTrue("Problem in Listing Forums",listForums.size()>0);
		
		
		for(Forum forum:listForums)
			
		{
			System.out.print(forum.getForumId()+"\t");
			System.out.print(forum.getForumName()+"\t");
			System.out.print(forum.getForumContent()+"\t");
			System.out.print(forum.getStatus()+"\t");
		}
		
	}
	
	
	@Ignore
	@Test
	public void approveForumTest() 
	{
		Forum forum=forumDAO.getForum(953);
        assertTrue("Problem in Approving Forum",forumDAO.approvedForum(forum));
		
	}		
		
	
	
	@Ignore
	@Test
	public void rejectForumTest() 
	{
		Forum forum=forumDAO.getForum(953);
        assertTrue("Problem in rejecting Forum",forumDAO.rejectForum(forum));
		
	}
	
	
}
