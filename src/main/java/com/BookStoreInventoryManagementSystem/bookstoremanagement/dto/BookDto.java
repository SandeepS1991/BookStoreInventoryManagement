package com.BookStoreInventoryManagementSystem.bookstoremanagement.dto;


import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookDto {

	public Long id;
	@NotNull(message = "ISBN is mandatory.")
	@NotEmpty(message = "ISBN cannot be empty.")
	@Size(min = 5, max = 15, message = "ISBN should be between 5 and 15 characters in length.")
	private String isbn;
	@NotNull(message = "Title is mandatory.")
	@NotEmpty(message = "Title cannot be empty.")
	private String title;
	private Set<AuthorDto> authors;
	@NotNull(message = "Year is mandatory.")
	@NotEmpty(message = "Year cannot be empty.")
	private String year;
	@NotNull(message = "Price is mandatory.")
	private Double price;
	@NotEmpty(message = "Genre cannot be empty.")
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
