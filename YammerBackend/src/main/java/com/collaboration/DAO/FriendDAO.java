package com.collaboration.DAO;

import java.util.List;

import com.collaboration.model.Friend;
import com.collaboration.model.UserDetail;

public interface FriendDAO 
   {
    
	public List<Friend> showFriendList(String username);
	public List<Friend> showPendingFriendRequest(String username);
	public List<UserDetail> showSuggestedFriend(String username);
	
	public boolean sendFriendRequest(Friend friend);
	public boolean acceptFriendRequest(int friendId);
	public boolean deleteFriendRequest(int friendId);
	
  }


