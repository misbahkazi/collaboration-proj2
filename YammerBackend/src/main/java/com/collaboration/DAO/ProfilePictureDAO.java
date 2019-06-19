package com.collaboration.DAO;

import com.collaboration.model.ProfilePicture;

public interface ProfilePictureDAO 
{
	public void saveProfilePicture(ProfilePicture profilePicture);
	public ProfilePicture getProfilePicture(String username);
}
