package com.collaboration.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collaboration.model.Friend;
import com.collaboration.model.UserDetail;

@Repository("friendDAO")
@Transactional


public class FriendDAOImpl implements FriendDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Friend> showFriendList(String username) 
	
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Friend where(username=:uname or friendusername=:frndusername)and status 'A'");
		query.setParameter("uname", username);
		query.setParameter("frndusername", username);
		List<Friend> listFriends=(List<Friend>)query.list();
		session.close();
		return listFriends;
	}
	
	

	@Override
	public List<Friend> showPendingFriendRequest(String username)  
	
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Friend where friendusername=:frndusername and status 'P'");
		query.setParameter("frndusername", username);
		List<Friend> listFriends=(List<Friend>)query.list();
		session.close();
		return listFriends;
	}
	
	

	/*@Override
	public List<UserDetail> showSuggestedFriend(String username) 
	
	{
		Session session=sessionFactory.openSession();
		Query sqlQuery=session.createSQLQuery("select username from UserDetail where username");
        List<String> listUsers=(List<String>)sqlQuery.list();
        ArrayList<UserDetail> listUserDetail=new ArrayList<UserDetail>();
        int i=0;
        return null ;
	} 
	public List<UserDetail> showSuggestedFriend(String loginname) {
		Session session = sessionFactory.openSession();
		SQLQuery query = session.createSQLQuery(
				"select loginname from userdetail where loginname not in (select friendloginname from friend where loginname='"
						+ loginname + "')and loginname!='" + loginname + "'");
		List<Object> suggestedFriendName = (List<Object>) query.list();
		List<UserDetail> suggestFriendList = new ArrayList<UserDetail>();
		int i = 0;
		while (i < suggestedFriendName.size()) {
			UserDetail userDetail = session.get(UserDetail.class, (String) suggestedFriendName.get(i));
			suggestFriendList.add(userDetail);
			i++;
		}
		return suggestFriendList;
	}*/
	@Override
	public boolean sendFriendRequest(Friend friend) 
	{
		try 
		{
			friend.setStatus("P");
			sessionFactory.getCurrentSession().save(friend);
			return true;
		}
		
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean acceptFriendRequest(int friendId) 
	
	{
		try 
		{
			Session session=sessionFactory.openSession();
			Friend friend=session.get(Friend.class,friendId);
			session.close();
			friend.setStatus("A");
			sessionFactory.getCurrentSession().update(friend);
			return true;
		}
		
		catch(Exception e)
		{
			return false;
		}
		
	}
	

	@Override
	public boolean deleteFriendRequest(int friendId) 
	
	{
		try 
		{
			Session session=sessionFactory.openSession();
			Friend friend=session.get(Friend.class,friendId);
			session.close();
			sessionFactory.getCurrentSession().delete(friend);
			return true;
		}
		
		catch(Exception e)
		{
			return false;
		}
	}



	@Override
	public List<UserDetail> showSuggestedFriend(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	
}

 