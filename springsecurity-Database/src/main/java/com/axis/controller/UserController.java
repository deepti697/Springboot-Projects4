package com.axis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.serviceimpl.UserDetailsServiceImpl;



@RestController
public class UserController {

	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;
	
	Logger log = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping(value = "/v1/user")
	public ResponseEntity<Object> getUser(){
		log.info("Inside getUser of UserController");
		return new ResponseEntity<Object>("User", HttpStatus.OK);
	}
	
	@GetMapping(value = "/v1/admin")
	public ResponseEntity<Object> getAdmin(){
		log.info("Inside getAdmin of UserController");
		return new ResponseEntity<Object>("Admin", HttpStatus.OK);
	}
	
	@GetMapping(value = "/v1/all")
	public ResponseEntity<Object> getAll(){
		log.info("Inside getAll of UserController");
		return new ResponseEntity<Object>(userDetailsServiceImpl.loadUserByUsername("ankit"), HttpStatus.OK);
	}
}
