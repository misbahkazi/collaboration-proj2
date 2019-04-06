package com.collaboration.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collaboration.model.UserDetail;
import com.collaboration.DAO.UserDAO;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO 
{   
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean registerUser(UserDetail user) {
		try
		{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e)
		{   
			System.out.println("Exception Arised:Adding User"+e);
			return false;
		}
	}

	@Override
	public boolean updateUserDetail(UserDetail user) {
		try
		{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{   
			System.out.println("Exception Arised:Updating User"+e);
			return false;
		}
	}

	@Override
	public UserDetail getUser(String username) {
		Session session=sessionFactory.openSession();
		UserDetail user=session.get(UserDetail.class,username);
		session.close();
		return user;
	}

	@Override
	public boolean makeOffLine(UserDetail user) {
		try 
		{
		user.setIsOnline("OFF");
		sessionFactory.getCurrentSession().update(user);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:Make off Line:"+e);
		return false;
		}
	}

	@Override
	public boolean makeOnLine(UserDetail user) {
		try 
		{
		user.setIsOnline("ON");
		sessionFactory.getCurrentSession().update(user);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:Make On Line:"+e);
		return false;
		}
	}

	@Override
	public boolean rejectUser(UserDetail user) {
		try 
		{
		user.setStatus("R");
		sessionFactory.getCurrentSession().update(user);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:Reject User:"+e);
		return false;
		}
	}

	@Override
	public boolean approveUser(UserDetail user) {
		try 
		{
		user.setStatus("A");
		sessionFactory.getCurrentSession().update(user);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:Approve User:"+e);
		return false;
		}
	}

}
