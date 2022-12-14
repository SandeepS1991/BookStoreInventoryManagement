package com.BookStoreInventoryManagementSystem.bookstoremanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.BookStoreInventoryManagementSystem.bookstoremanagement.entity.UserEntity;


@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

	
	UserEntity findByUsername(String username);
}
