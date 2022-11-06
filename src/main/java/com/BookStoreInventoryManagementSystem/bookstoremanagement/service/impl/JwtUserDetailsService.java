package com.BookStoreInventoryManagementSystem.bookstoremanagement.service.impl;


import java.util.ArrayList;
import java.util.List;

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
import com.BookStoreInventoryManagementSystem.bookstoremanagement.exception.BusinessException;
import com.BookStoreInventoryManagementSystem.bookstoremanagement.exception.ErrorModel;
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
		
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
		
	}
	
	public UserDto save(UserDto user) {
	
		
		System.out.println("USER: "+user.toString());
		UserEntity newUser = new UserEntity();
		newUser = userRepo.findByUsername(user.getUsername());
		if(newUser == null) {
		UserEntity newUserToBeCreated = new UserEntity();
		newUserToBeCreated.setUsername(user.getUsername());
		newUserToBeCreated.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUserToBeCreated.setRole(user.getRole());
		
		newUserToBeCreated = userRepo.save(newUserToBeCreated);
		user.setUsername(newUserToBeCreated.getUsername());
		user.setPassword(newUserToBeCreated.getPassword());
		user.setRole(newUserToBeCreated.getRole());
		
		return user;
		}
		else {
			List<ErrorModel> errorModelList = new ArrayList<>();
			ErrorModel errorModel = new ErrorModel();
			errorModel.setCode("USERNAME_INVALID");
			errorModel.setMessage("This username already exists.");
			errorModelList.add(errorModel);
			
			throw new BusinessException(errorModelList);
		}
		

	}
	
}