package com.dell.eln.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	
	@GetMapping("hw")
	public String helloWorld() {
		return "Hi there" ; 
	}
	
	

}
