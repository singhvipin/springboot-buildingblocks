package com.dell.eln.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import com.dell.eln.entities.User;
import com.dell.eln.exceptions.UserNotFoundException;
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
	public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder builder) {
		User createUser = userService.createUser(user);
		HttpHeaders headers = new HttpHeaders(); 
		headers.setLocation(builder.path("/user/{id}").buildAndExpand(createUser.getId()).toUri());
		
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED); 
	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable Long id ) {
		Optional<User> user;
		try {
			user = userService.getUser(id);
			
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}   
		return user.get(); 
	}
	
	@GetMapping("/users/byUsername/{username}")
	public User getUser(@PathVariable String username ) {
		return userService.getUserByUsername(username); 
	}

}
