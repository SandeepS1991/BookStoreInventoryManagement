package com.BookStoreInventoryManagementSystem.bookstoremanagement.dto;

import java.util.List;
import java.util.Set;

public class BookDto {

	public Long id;
	private String isbn;
	private String title;
	private Set<AuthorDto> authors;
	private String year;
	private Double price;
	private String genre;
	
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Set<AuthorDto> getAuthors() {
		return authors;
	}
	public void setAuthors(Set<AuthorDto> authors) {
		this.authors = authors;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BookDto(String isbn, String title, Set<AuthorDto> authors, String year, Double price, String genre) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.authors = authors;
		this.year = year;
		this.price = price;
		this.genre = genre;
	}
	public BookDto() {
	}
	
	
	
	
}
