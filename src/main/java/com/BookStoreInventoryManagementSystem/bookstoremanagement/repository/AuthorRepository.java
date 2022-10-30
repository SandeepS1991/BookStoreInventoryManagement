package com.BookStoreInventoryManagementSystem.bookstoremanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.BookStoreInventoryManagementSystem.bookstoremanagement.entity.AuthorEntity;

@Repository
public interface AuthorRepository extends CrudRepository<AuthorEntity, Long>{

	Optional<List<AuthorEntity>> findByName(String name);
	
}
