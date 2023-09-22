package com.getinfy.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.getinfy.dto.UserDto;
import com.getinfy.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserRestController {
	
	@Autowired
	private UserService userservice;
	@PostMapping("/saveUser")
	public ResponseEntity<?> saveUser(@RequestBody @Valid UserDto userdto){
		
		boolean saveUser = userservice.saveUser(userdto);
		if(saveUser) {
			
			return new ResponseEntity<String>("Details saved successfully.",HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("issue with the saving.",HttpStatus.BAD_REQUEST);
		
		
	}
	
	
	

}
