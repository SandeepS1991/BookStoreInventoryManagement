package com.BookStoreInventoryManagementSystem.bookstoremanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.BookStoreInventoryManagementSystem.bookstoremanagement.entity.AuthorEntity;

@Repository
public interface AuthorRepository extends CrudRepository<AuthorEntity, Long>{

	List<AuthorEntity> findByNameEquals(String name);
	
//	@Modifying
//	@Query("delete from AuthorEntity a where a.book_id=:bookId")
//	void deleteBooks(@Param("bookId") String bookId);
	
	@Modifying 
    @Query(value = "DELETE FROM Author WHERE book_id =:bookId",nativeQuery = true) 
	// if want to write nativequery then mask nativeQuery  as true
    int deleteByBookIdNative(@Param("bookId") Long bookId); 
}
