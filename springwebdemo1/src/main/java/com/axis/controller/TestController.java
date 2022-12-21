package com.axis.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("api/v1")
public class TestController {
	
	//creating arraylist for fruits
	ArrayList<String> fruits= new ArrayList<String>();
	
	//creating constructor for getting all fruits
	public TestController() {
		fruits.add("apple");
		fruits.add("mango");
		fruits.add("banana");
		fruits.add("kiwi");
	}
	
	@GetMapping("/getfruits")
	public List<String> getAllFruits(){
		return fruits;
	}
	
//	@PostMapping("/addfruits")
//	public List<String> addFruits(@RequestBody String addfruits){
//		return fruits;
//	}
	
	

}
