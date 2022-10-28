package com.BookStoreInventoryManagementSystem.bookstoremanagement.dto;

import java.util.List;

public class BookDto {

	public Long id;
	private String isbn;
	private String title;
	private List<AuthorDto> authors;
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
	public List<AuthorDto> getAuthors() {
		return authors;
	}
	public void setAuthors(List<AuthorDto> authors) {
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

	public BookDto(String isbn, String title, List<AuthorDto> authors, String year, Double price, String genre) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.authors = authors;
		this.year = year;
		this.price = price;
		this.genre = genre;
	}
	public BookDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
