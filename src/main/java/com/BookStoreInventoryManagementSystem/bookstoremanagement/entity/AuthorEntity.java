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

	@ManyToOne
	@JoinColumn(name="book_id", nullable=false)
	private BookEntity bookEntity;

	
	public AuthorEntity() {
	}

	

	public AuthorEntity(Long id, String name, String dateOfBirth, BookEntity bookEntity) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.bookEntity = bookEntity;
	}



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public BookEntity getBookEntity() {
		return bookEntity;
	}


	public void setBookEntity(BookEntity bookEntity) {
		this.bookEntity = bookEntity;
	}

	
	
}
	
