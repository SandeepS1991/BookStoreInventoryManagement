package com.BookStoreInventoryManagementSystem.bookstoremanagement.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.BookStoreInventoryManagementSystem.bookstoremanagement.entity.AuthorEntity;

@Repository
public interface AuthorRepository extends CrudRepository<AuthorEntity, Long>{

	List<AuthorEntity> findByNameEquals(String name);
}
