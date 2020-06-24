package com.example.demo.service;

import org.springframework.http.ResponseEntity;

import com.example.demo.entity.User;

public interface UserService {

	//public ResponseEntity<?> createUser(User newUser);
	
	public User getByEmail(String email);
}
