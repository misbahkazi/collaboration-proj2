package com.collaboration.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.collaboration.DAO.ProfilePictureDAO;
import com.collaboration.model.ProfilePicture;
import com.collaboration.model.UserDetail;

@RestController
public class ProfilePictureController 
{
	@Autowired
	ProfilePictureDAO profilePictureDAO;
	
	@RequestMapping(value="/doUpload",method=RequestMethod.POST)
	public ResponseEntity<?> uploadPicture(@RequestParam(value="file")CommonsMultipartFile fileUpload,HttpSession session)
	{
		
		UserDetail userDetail=(UserDetail)session.getAttribute("userDetail");
		
		if(userDetail==null)
		{
			return new ResponseEntity<String>("Unauthorized User",HttpStatus.NOT_FOUND);
		}
		else
		{
			ProfilePicture profilePicture=new ProfilePicture();
			profilePicture.setImage(fileUpload.getBytes());
			profilePicture.setUsername(userDetail.getUsername());
			profilePictureDAO.save(profilePicture);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/getImage/{username}",method=RequestMethod.GET)
	public @ResponseBody byte[] getProfilePicture(@PathVariable("username")String username,HttpSession session)
	{
		ProfilePicture profilePicture=profilePictureDAO.getProfilePicture(username);
		
		if(profilePicture!=null)
		{
			return profilePicture.getImage();
		}
		else
		{
			return null;
		}
	}
}
