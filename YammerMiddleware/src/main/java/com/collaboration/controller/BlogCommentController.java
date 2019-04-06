package com.collaboration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.collaboration.DAO.BlogCommentDAO;
import com.collaboration.model.BlogComment;

@RestController
public class BlogCommentController 
{
	
	@Autowired
	BlogCommentDAO blogCommentDAO;
	
	 @GetMapping(value="/getBlogComment/{blogId}")
		public ResponseEntity<List<BlogComment>> getBlogComments(@PathVariable("blogId")int blogId)
		{
	    	List<BlogComment> listBlogComment=blogCommentDAO.listBlogComment(blogId);
	    	if(listBlogComment.size()>0)
	    	{
	    		return new ResponseEntity<List<BlogComment>>(listBlogComment,HttpStatus.OK);
	    	}
	    	else
	    	{
	    		return new ResponseEntity<List<BlogComment>>(listBlogComment,HttpStatus.INTERNAL_SERVER_ERROR);
	    	}
	    	
		}
	 
	 
	 
	 @PostMapping(value="/addBlogComment")
	    public ResponseEntity<String>addBlogComment(@RequestBody BlogComment comment)
	    {
	    	
	    	comment.setCommentDate(new java.util.Date());
	    	if(blogCommentDAO.addBlogComment(comment))
	    	{
	    		return new ResponseEntity<String>("Successful",HttpStatus.OK);
	    	}
	    	else
	    	{
	    		return new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
	    	}
	    }
	 
	 @GetMapping(value="/deleteBlogComment")
	    public ResponseEntity<String>deleteBlogComment(@RequestBody BlogComment comment)
	    {
	    	
	    	comment.setCommentDate(new java.util.Date());
	    	if(blogCommentDAO.deleteBlogComment(comment))
	    	{
	    		return new ResponseEntity<String>("Successful",HttpStatus.OK);
	    	}
	    	else
	    	{
	    		return new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
	    	}
	    }

}
