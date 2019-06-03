package com.collaboration.DAO;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

import com.collaboration.model.ProfilePicture;

@Repository("profilePictureDAO")
@Transactional
public class ProfilePictureDAOImpl implements ProfilePictureDAO 

{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void save(ProfilePicture profilePicture) 
	{
		System.out.println("I am in Save Method- Profile Picture");
		Session session=sessionFactory.openSession();
		session.saveOrUpdate(profilePicture);
		session.flush();
		session.close();
		System.out.println("Image Saved to Database");
		
	}

	@Override
	public ProfilePicture getProfilePicture(String username) 
	{

		Session session=sessionFactory.openSession();
		ProfilePicture profilePicture=session.get(ProfilePicture.class,username);
		session.close();
		return profilePicture;
	}

}
