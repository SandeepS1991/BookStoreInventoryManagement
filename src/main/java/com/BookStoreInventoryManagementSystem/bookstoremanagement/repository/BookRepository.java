package com.BookStoreInventoryManagementSystem.bookstoremanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.BookStoreInventoryManagementSystem.bookstoremanagement.entity.BookEntity;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Long>{

}
