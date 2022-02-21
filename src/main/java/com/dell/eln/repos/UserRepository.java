package com.dell.eln.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dell.eln.entities.User;

public interface UserRepository  extends JpaRepository<User, Long>{
	User findByUsername(String username);
}
