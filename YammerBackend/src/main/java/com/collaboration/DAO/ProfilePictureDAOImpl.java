package com.collaboration.DAO;


import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.collaboration.model.ProfilePicture;

@Repository("profilePictureDAO")
@Transactional
public class ProfilePictureDAOImpl implements ProfilePictureDAO 

{
	

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveProfilePicture(ProfilePicture profilePicture) 
	{
		Session s=sessionFactory.getCurrentSession();
		s.saveOrUpdate(profilePicture);
	}

	@Override
	public ProfilePicture getProfilePicture(String username) 
	{
		Session s=sessionFactory.getCurrentSession();
		ProfilePicture profilePicture=(ProfilePicture)s.get(ProfilePicture.class, username);
		return profilePicture;
	}

}
