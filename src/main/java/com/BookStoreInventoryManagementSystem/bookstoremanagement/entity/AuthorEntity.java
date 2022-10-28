package com.BookStoreInventoryManagementSystem.bookstoremanagement.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="author")
public class AuthorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String dateOfBirth;
	
	public AuthorEntity() {
	}

	
	
}
	
