package com.dell.eln.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dell.eln.entities.User;
import com.dell.eln.exceptions.UserNotFoundException;
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

	public Optional<User> getUser(Long id) throws UserNotFoundException{
		Optional<User> user = userRepository.findById(id);
		if(user.isEmpty()) {
			throw new UserNotFoundException("User Not Found in the repo"); 
		}
		return user; 
	}
	
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username); 
	}
}
