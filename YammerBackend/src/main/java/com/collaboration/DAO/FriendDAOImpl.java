package com.collaboration.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
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
		Query query=session.createQuery("from Friend where (username=:uname or friendusername=:frndusername) and status='A'");
		query.setParameter("uname",username);
		query.setParameter("frndusername",username);
		List<Friend> listFriends=(List<Friend>)query.list();
		session.close();
		return listFriends;
	}

	

	@Override
	public List<Friend> showPendingFriendRequest(String username) 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Friend where (username=:uname or friendusername=:frndusername) and status='P'");
		query.setParameter("uname",username);
		query.setParameter("frndusername",username);
		List<Friend> listFriends=(List<Friend>)query.list();
		session.close();
		return listFriends;
	}
	
	
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
		
	
		Session session=sessionFactory.openSession();
		Query sqlQuery=session.createSQLQuery("select username from userdetail where username not in(select friendusername from Friend where username='"+username+"' and (status='A' or status='P'))and username not in(select username from Friend where friendusername='"+username+"'and(status='A' or status='P'))and username!='"+username+"");
		List<String> listUsers=(List<String>)sqlQuery.list();
		ArrayList<UserDetail> listUserDetail=new ArrayList<UserDetail>();
		int i=0;
		while(i<listUsers.size())
		{
			UserDetail user=session.get(UserDetail.class, listUsers.get(i).toString().trim());
			listUserDetail.add(user);
			i++;
		}
		
		return listUserDetail;
		
	}

	
}

 