package com.BookStoreInventoryManagementSystem.bookstoremanagement.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table
public class BookEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String isbn;
	private String title;

	private String year;
	private Double price;
	private String genre;

	@EqualsAndHashCode.Exclude // <<<<<<<<<<
	@ToString.Exclude // <<<<<<<
	@OneToMany(mappedBy="bookEntity")
	private Set<AuthorEntity> authorEntitySet;

	
	
	
	
	public BookEntity() {
	}

	public BookEntity(Long id, String isbn, String title, String year, Double price, String genre,
			Set<AuthorEntity> authorEntitySet) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.year = year;
		this.price = price;
		this.genre = genre;
		this.authorEntitySet = authorEntitySet;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Set<AuthorEntity> getAuthorEntitySet() {
		return authorEntitySet;
	}

	public void setAuthorEntitySet(Set<AuthorEntity> authorEntitySet) {
		this.authorEntitySet = authorEntitySet;
	}
	
	
	
	
	

}
