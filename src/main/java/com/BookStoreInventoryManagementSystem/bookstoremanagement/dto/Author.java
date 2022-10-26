package com.BookStoreInventoryManagementSystem.bookstoremanagement.dto;

public class Author {

	private String name;
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
	
	public Author(String name, String dateOfBirth) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}
	
	
	
}
