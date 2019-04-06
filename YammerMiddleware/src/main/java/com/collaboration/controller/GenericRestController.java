package com.collaboration.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenericRestController {
     
	
	@GetMapping(value="/demo")
	public ResponseEntity<String> checkDemo()
	{
		return new ResponseEntity<String>("Demo String",HttpStatus.OK); 
	}
	

}
