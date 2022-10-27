package com.BookStoreInventoryManagementSystem.bookstoremanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.BookStoreInventoryManagementSystem.bookstoremanagement.entity.AuthorEntity;

@Repository
public interface AuthorRepository extends CrudRepository<AuthorEntity, Long>{

}
