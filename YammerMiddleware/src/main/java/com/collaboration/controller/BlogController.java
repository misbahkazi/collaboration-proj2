package com.collaboration.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.collaboration.DAO.BlogDAO;
import com.collaboration.model.Blog;

@RestController
public class BlogController 
{
    @Autowired
    BlogDAO blogDAO;
    
    @GetMapping(value="/getBlogDetails")
	public ResponseEntity<List<Blog>> getBlogDetails(HttpSession session)
	{
    	List<Blog> listBlogs=blogDAO.getAllBlogs();
    	if(listBlogs.size()>0)
    	{
    		return new ResponseEntity<List<Blog>>(listBlogs,HttpStatus.OK);
    	}
    	else
    	{
    		return new ResponseEntity<List<Blog>>(listBlogs,HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	
	}
     
    @PostMapping(value="/addBlog")
    public ResponseEntity<String>addBlog(@RequestBody Blog blog)
    {
    	
    	blog.setCreateDate(new java.util.Date());
    	if(blogDAO.addBlog(blog))
    	{
    		return new ResponseEntity<String>("Successful",HttpStatus.OK);
    	}
    	else
    	{
    		return new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
    
    @PostMapping(value="/updateBlog")
    public ResponseEntity<String>updateBlog(@RequestBody Blog blog)
    {
    	
    	blog.setCreateDate(new java.util.Date());
    	if(blogDAO.updateBlog(blog))
    	{
    		return new ResponseEntity<String>("Successful",HttpStatus.OK);
    	}
    	else
    	{
    		return new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
    
    
    @GetMapping(value="/deleteBlog/{blogId}")
    public ResponseEntity<String>deleteBlog(@PathVariable("blogId")int blogId)
    {
    	Blog blog=blogDAO.getBlog(blogId);
    	
    	if(blogDAO.deleteBlog(blog))
    	{
    		return new ResponseEntity<String>("Successful",HttpStatus.OK);
    	}
    	else
    	{
    		return new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
    
    
    
    
    
    
    @GetMapping(value="/incrementLikes/{blogId}")
    public ResponseEntity<String>incrementLikes(@PathVariable("blogId")int blogId)
    {
    	Blog blog=blogDAO.getBlog(blogId);
    	
    	if(blogDAO.incrementLikes(blog))
    	{
    		return new ResponseEntity<String>("Successful",HttpStatus.OK);
    	}
    	else
    	{
    		return new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
    
    

    @GetMapping(value="/incrementDislikes/{blogId}")
    public ResponseEntity<String>incrementDislikes(@PathVariable("blogId")int blogId)
    {
    	Blog blog=blogDAO.getBlog(blogId);
    	
    	if(blogDAO.incrementDislikes(blog))
    	{
    		return new ResponseEntity<String>("Successful",HttpStatus.OK);
    	}
    	else
    	{
    		return new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
    
    
    @GetMapping(value="/approvedBlog/{blogId}")
    public ResponseEntity<String>approvedBlog(@PathVariable("blogId")int blogId)
    {
    	Blog blog=blogDAO.getBlog(blogId);
    	
    	if(blogDAO.approvedBlog(blog))
    	{
    		return new ResponseEntity<String>("Successful",HttpStatus.OK);
    	}
    	else
    	{
    		return new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
    
    
    @GetMapping(value="/rejectBlog/{blogId}")
    public ResponseEntity<String>rejectBlog(@PathVariable("blogId")int blogId)
    {
    	Blog blog=blogDAO.getBlog(blogId);
    	
    	if(blogDAO.rejectBlog(blog))
    	{
    		return new ResponseEntity<String>("Successful",HttpStatus.OK);
    	}
    	else
    	{
    		return new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }  
    
    @GetMapping(value="/getBlog/{blogId}")
    public ResponseEntity<Blog> getBlog(@PathVariable("blogId")int blogId)
    {
    	Blog blog=blogDAO.getBlog(blogId);
    	
    	if(blog!=null)
    	{
    		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
    	}
    	else
    	{
    		return new ResponseEntity<Blog>(blog,HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	
    	
    }
    
}