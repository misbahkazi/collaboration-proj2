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

import com.collaboration.DAO.ForumCommentDAO;
import com.collaboration.model.BlogComment;
import com.collaboration.model.ForumComment;

@RestController
public class ForumCommentController {
	
	@Autowired
	
	ForumCommentDAO forumCommentDAO;
	
	
	 @GetMapping(value="/getForumComment/{forumId}")
	 
		public ResponseEntity<List<ForumComment>> getForumComment(@PathVariable("forumId")int forumId)
		{
	    	List<ForumComment> listForumComment=forumCommentDAO.listForumComment(forumId);
	    	if(listForumComment.size()>0)
	    	{
	    		return new ResponseEntity<List<ForumComment>>(listForumComment,HttpStatus.OK);
	    	}
	    	else
	    	{
	    		return new ResponseEntity<List<ForumComment>>(listForumComment,HttpStatus.INTERNAL_SERVER_ERROR);
	    	}
	    	
		}
	 
	 
	 
	 @PostMapping(value="/addForumComment")
	    public ResponseEntity<String>addForumComment(@RequestBody ForumComment comment)
	    {
	    	
	    	comment.setCommentDate(new java.util.Date());
	    	if(forumCommentDAO.addForumComment(comment))
	    	{
	    		return new ResponseEntity<String>("Successful",HttpStatus.OK);
	    	}
	    	else
	    	{
	    		return new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
	    	}
	    }
	 
	 @GetMapping(value="/deleteForumComment/{commentId}")
	    public ResponseEntity<String> deleteForumComment(@PathVariable("commentId")int commentId)
	    {
		 ForumComment forumcomment=forumCommentDAO.getForumComment(commentId);
	    	
	    	if(forumCommentDAO.deleteForumComment(forumcomment))
	    	{
	    		return new ResponseEntity<String>("Successful",HttpStatus.OK);
	    	}
	    	else
	    	{
	    	
	    		return new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
	    	}
	    	
	    	
	    }


	

}
