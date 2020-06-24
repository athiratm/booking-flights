package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	/*
	 * @Autowired(required = true) private BCryptPasswordEncoder
	 * bCryptPasswordEncoder;
	 * 
	 * @Override public ResponseEntity<User> createUser(User newUser) {
	 * Optional<User> findUserById = userRepository.findByEmail(newUser.getEmail());
	 * try { if (!findUserById.isPresent()) {
	 * newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
	 * userRepository.save(newUser); return new ResponseEntity<User>(newUser,
	 * HttpStatus.OK); } else throw new RecordAlreadyPresentException(
	 * "User with Id: " + newUser.getUserId() + " already exists!!");
	 * 
	 * } catch (Exception e) {
	 * 
	 * return new ResponseEntity<>(HttpStatus.NOT_FOUND); } return null; }
	 */

	@Override
	public User getByEmail(String email) {
		Optional<User> user = userRepository.findByEmail(email);
		return user.get();
	}

}
