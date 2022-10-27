package com.BookStoreInventoryManagementSystem.bookstoremanagement.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.NoArgsConstructor;


@Entity
@Table(name = "BOOK_TABLE")
@NoArgsConstructor
public class BookEntity {
	
	@Id
	private String isbn;
	private String title;
	@OneToMany(targetEntity = AuthorEntity.class, cascade = CascadeType.ALL)
	@JoinColumn(name="ba_fk",referencedColumnName = "isbn")
	private List<AuthorEntity> authorEntities;
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
	public List<AuthorEntity> getAuthorEntities() {
		return authorEntities;
	}
	public void setAuthorEntities(List<AuthorEntity> authorEntities) {
		this.authorEntities = authorEntities;
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
	
	
	
	
}
