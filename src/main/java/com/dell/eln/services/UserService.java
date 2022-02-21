package com.dell.eln.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dell.eln.entities.User;
import com.dell.eln.repos.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository ; 
	
	public List<User> getAllUsers(){
		return userRepository.findAll(); 
	}
	
	public User createUser(User user) {
		return userRepository.save(user);
	}

	public User getUser(Long id) {
		return userRepository.findById(id).get(); 
	}
	
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username); 
	}
}
