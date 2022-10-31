package com.BookStoreInventoryManagementSystem.bookstoremanagement.service.impl;


import java.util.ArrayList;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.BookStoreInventoryManagementSystem.bookstoremanagement.converter.UserConverter;
import com.BookStoreInventoryManagementSystem.bookstoremanagement.dto.UserDto;
import com.BookStoreInventoryManagementSystem.bookstoremanagement.entity.UserEntity;
import com.BookStoreInventoryManagementSystem.bookstoremanagement.repository.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

//	@Autowired
//	private UserDto userDto;
	
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PasswordEncoder bcryptEncoder;
//	@Lazy
//	@Autowired
//	private UserConverter userConverter;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userRepo.findByUsername(username);
		
//		if ("javainuse".equals(username)) {
//			return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
//					new ArrayList<>());
//		} else {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
		
	}
	
	public UserDto save(UserDto user) {
		UserEntity newUser = new UserEntity();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setRole(user.getRole());
		
		newUser = userRepo.save(newUser);
		user.setUsername(newUser.getUsername());
		user.setPassword(newUser.getPassword());
		user.setRole(newUser.getRole());
		
		return user;
	}
	
}