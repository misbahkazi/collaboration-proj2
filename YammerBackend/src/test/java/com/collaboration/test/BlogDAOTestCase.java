package com.collaboration.test;

import static org.junit.Assert.assertTrue;



import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collaboration.DAO.BlogDAO;
import com.collaboration.model.Blog;





public class BlogDAOTestCase {
	
	
	static BlogDAO blogDAO;
	
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.collaboration");
		context.refresh();	
		blogDAO=(BlogDAO)context.getBean("blogDAO");
	}

	@Ignore
//@Test
	public void addBlogTest() 
	{
		Blog blog=new Blog();
		blog.setBlogName("c");
		blog.setBlogContent("c prog");
		blog.setCreateDate(new java.util.Date());
		blog.setDislikes(0);
		blog.setLikes(0);
		blog.setStatus("NA");
		blog.setUsername("xyz");
		assertTrue("Problem in adding Blog",blogDAO.addBlog(blog));
	}
	
	@Ignore
	//@Test
	public void updateBlogTest() 
	{
		Blog blog=blogDAO.getBlog(953);
		blog.setBlogContent("Adv java");
		assertTrue("Problem in updating Blog",blogDAO.updateBlog(blog));
	}
	
	
	@Ignore
	//@Test
	public void deleteBlogTest() 
	{
		Blog blog=blogDAO.getBlog(1013);
		assertTrue("Problem in deleting Blog",blogDAO.deleteBlog(blog));
	}
	
	
	@Ignore
    //@Test
	public void listBlogTest() 
	{
		
		List<Blog> listBlogs=blogDAO.getAllBlogs();
		assertTrue("Problem in Listing Blogs",listBlogs.size()>0);
		
		
		for(Blog blog:listBlogs)
			
		{
			System.out.print(blog.getBlogId()+"\t");
			System.out.print(blog.getBlogName()+"\t");
			System.out.print(blog.getBlogContent()+"\t");
			System.out.print(blog.getStatus()+"\t");
		}
		
	}
	
	
	//@Ignore
	@Test
	public void approveBlogTest() 
	{
		Blog blog=blogDAO.getBlog(992);
        assertTrue("Problem in Approving Blog",blogDAO.approvedBlog(blog));
		
	}		
		
	
	
	@Ignore
	//@Test
	public void rejectBlogTest() 
	{
		Blog blog=blogDAO.getBlog(952);
        assertTrue("Problem in rejecting Blog",blogDAO.rejectBlog(blog));
		
	}
	
	
	@Ignore
	//@Test
	public void incrementLikesTest() 
	{
		Blog blog=blogDAO.getBlog(952);
		assertTrue("Problem in Increment Likes:",blogDAO.incrementLikes(blog));
		
	}
	
	
	@Ignore
	//@Test
	public void incrementDislikesTest() 
	{
		Blog blog=blogDAO.getBlog(952);
        assertTrue("Problem in Increment Dislikes:",blogDAO.incrementDislikes(blog));
		
	}
}
