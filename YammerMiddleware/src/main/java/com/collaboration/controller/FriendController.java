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

import com.collaboration.DAO.FriendDAO;
import com.collaboration.model.Friend;
import com.collaboration.model.UserDetail;

@RestController
public class FriendController 
{   
	@Autowired
    FriendDAO friendDAO;
    

	
	@GetMapping(value="/showFriendList/{username}")
	public ResponseEntity<List<Friend>> showFriendList(@PathVariable("username")String username)
	{
		List<Friend> friendList=friendDAO.showFriendList(username);
		if(friendList.size()>0)
		{
			return new ResponseEntity<List<Friend>>(friendList,HttpStatus.OK);
		
		}
		else
		{
			return new ResponseEntity<List<Friend>>(friendList,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/showPendingFriendList/{username}")
	public ResponseEntity<List<Friend>> showPendingFriendList(@PathVariable("username")String username)
	{
		List<Friend> pendingfriendList=friendDAO.showPendingFriendRequest(username);
		if(pendingfriendList.size()>0)
		{
			return new ResponseEntity<List<Friend>>(pendingfriendList,HttpStatus.OK);
		
		}
		else
		{
			return new ResponseEntity<List<Friend>>(pendingfriendList,HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping(value="/showSuggestedFriendList/{username}")
	public ResponseEntity<List<UserDetail>> showSuggestedFriendList(@PathVariable("username")String username)
	{
		List<UserDetail> suggestedfriendList=friendDAO.showSuggestedFriend(username);
		if(suggestedfriendList.size()>0)
		{
			return new ResponseEntity<List<UserDetail>>(suggestedfriendList,HttpStatus.OK);
		
		}
		else
		{
			return new ResponseEntity<List<UserDetail>>(suggestedfriendList,HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping(value="/deleteFriendRequest/{friendId}")
	public ResponseEntity<String> deleteFriendRequest(@PathVariable("friendId")int friendId)
	{
		
		if(friendDAO.deleteFriendRequest(friendId))
		{
			return new ResponseEntity<String>("Success",HttpStatus.OK);
		
		}
		else
		{
			return new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping(value="/acceptFriendRequest/{friendId}")
	public ResponseEntity<String> acceptFriendRequest(@PathVariable("friendId")int friendId)
	{
		
		if(friendDAO.acceptFriendRequest(friendId))
		{
			return new ResponseEntity<String>("Success",HttpStatus.OK);
		
		}
		else
		{
			return new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@PostMapping(value="/sendFreindRequest")
	public ResponseEntity<String> sendFriendRequest(@RequestBody Friend friend)
	{
		if(friendDAO.sendFriendRequest(friend))
		{
			return new ResponseEntity<String>("Success",HttpStatus.OK);
			
		}
		else
		{
			return new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
