package com.dell.eln.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dell.eln.entities.User;
import com.dell.eln.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	
	
	@GetMapping("/users")
	public List<User>  getAllUsers(){
		System.out.println("Getting all users");
		return userService.getAllUsers(); 
	}
	
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable Long id ) {
		return userService.getUser(id); 
	}
	
	@GetMapping("/users/byUsername/{username}")
	public User getUser(@PathVariable String username ) {
		return userService.getUserByUsername(username); 
	}

}
