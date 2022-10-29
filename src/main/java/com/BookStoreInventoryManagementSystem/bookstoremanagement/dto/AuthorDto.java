package com.BookStoreInventoryManagementSystem.bookstoremanagement.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AuthorDto {
	
	public Long id;
	@NotNull(message = "Name is mandatory.")
	@NotEmpty(message = "Name cannot be empty.")
	private String name;
	@NotNull(message = "Date of Birth is mandatory.")
	@NotEmpty(message = "Date of Birth cannot be empty.")
	private String dateOfBirth;
	
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
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public AuthorDto(String name, String dateOfBirth) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}
	public AuthorDto() {
	}
	
	
	
}
