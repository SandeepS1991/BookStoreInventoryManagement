package com.BookStoreInventoryManagementSystem.bookstoremanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.BookStoreInventoryManagementSystem.bookstoremanagement.entity.AuthorEntity;
import com.BookStoreInventoryManagementSystem.bookstoremanagement.entity.BookEntity;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Long>{

	
	Optional<BookEntity> findByIdAndTitle(Long id, String title);
	
	Optional<List<BookEntity>> findByTitle(String title);
}
