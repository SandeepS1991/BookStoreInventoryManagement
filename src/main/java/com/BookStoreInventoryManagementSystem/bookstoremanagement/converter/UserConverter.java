package com.BookStoreInventoryManagementSystem.bookstoremanagement.converter;


import com.BookStoreInventoryManagementSystem.bookstoremanagement.dto.UserDto;
import com.BookStoreInventoryManagementSystem.bookstoremanagement.entity.UserEntity;

public class UserConverter {

	public UserEntity convertDtoToEntity(UserDto userDto) {
		UserEntity userEntity = new UserEntity();
		userEntity.setUsername(userDto.getUsername());
		userEntity.setPassword(userDto.getPassword());
		userEntity.setRole(userDto.getRole());
		return userEntity;
	}
	
	public UserDto convertEntityToDTO(UserEntity userEntity) {
		UserDto userDto = new UserDto();
		userDto.setUsername(userEntity.getUsername());
		userDto.setPassword(userEntity.getPassword());
		userDto.setRole(userEntity.getRole());
		return userDto;
	}
	
	
}
