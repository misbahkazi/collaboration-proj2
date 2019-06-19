package com.collaboration.test;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.collaboration.DAO.FriendDAO;
import com.collaboration.model.Friend;

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
	
	@Ignore
	//@Test
	public void sendFriendRequest()
	{ 
		Friend friend=new Friend();
		
		friend.setUsername("alice");
		friend.setFriendusername("dan");
		
		assertTrue("Problem in sending friend request",friendDAO.sendFriendRequest(friend));
	}
	
	//@Ignore
      @Test
	public void acceptFriendRequest()
	{
		
		assertTrue("Problem in accepting friend request",friendDAO.acceptFriendRequest(993));
	}
	
	@Ignore
	//@Test
	public void deleteFriendRequest()
	{
		assertTrue("Problem in deleting friend request",friendDAO.deleteFriendRequest(954));
	}
	
	@Ignore
	//@Test
	public void showFriendListTest()
	{
		List<Friend> friendList=friendDAO.showFriendList("mac");
		assertTrue("Problem in Showing Friend List",friendList.size()>0);
		
		System.out.println("FRIEND LIST:");
		
		for(Friend friend:friendList)
		{
			System.out.println(friend.getUsername()+" ");
			System.out.println(friend.getFriendusername());
			
		}
	}
	
	@Ignore
	//@Test
	public void showPendingFriendRequest()
	{
		List<Friend> friendList=friendDAO.showPendingFriendRequest("mac");
		assertTrue("Problem in Showing pending Friend reuqest List",friendList.size()>0);
		
		System.out.println("******Pending FriendRequestList******");
		
		for(Friend friend:friendList)
		{
			System.out.println(friend.getUsername()+"      ");
			System.out.println(friend.getFriendusername());
			
		}
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	