package com.BookStoreInventoryManagementSystem.bookstoremanagement.entity;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class AuthorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long author_id;
	private String name;
	private String dateOfBirth;
	
}
	
