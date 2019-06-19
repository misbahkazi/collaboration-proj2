package com.collaboration.controller;

import java.io.IOException;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.collaboration.DAO.ProfilePictureDAO;
import com.collaboration.model.ProfilePicture;
import com.collaboration.model.UserDetail;
import com.collaboration.model.ErrorClass;



@RestController
public class ProfilePictureController 
{
	@Autowired
	private ProfilePictureDAO profilePictureDAO;
	
	
	
	
	@RequestMapping(value="/ProfilePictureUpload",method=RequestMethod.POST)
	public ResponseEntity<?> ProfilePictureUpload(@RequestParam(value="file") CommonsMultipartFile fileUpload,@RequestParam(value="username")String name,HttpSession session)
	{   		
	String	userDetail=(String)session.getAttribute("username");
		System.out.println("uploading picture"+name);
	
		ProfilePicture profilePicture= new ProfilePicture();
	    System.out.println(fileUpload.getBytes());
		System.out.println("picture uploaded");

		profilePicture.setImage(fileUpload.getBytes());
		profilePicture.setUsername(name);

		profilePictureDAO.saveProfilePicture(profilePicture);
		return new ResponseEntity<String>("ok",HttpStatus.OK);
	}
	
	
	
	
	@GetMapping(value="/getImage/{username}")
	public @ResponseBody byte[] getProfilePicture(@PathVariable("username")String username, HttpStatus session)
	{
		System.out.println("Username: " + username);
		ProfilePicture profilePicture=profilePictureDAO.getProfilePicture(username);
		return profilePicture.getImage();
    }
	
	
	
	
}