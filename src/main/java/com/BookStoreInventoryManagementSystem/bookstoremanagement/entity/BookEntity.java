package com.BookStoreInventoryManagementSystem.bookstoremanagement.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@NoArgsConstructor
public class BookEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String isbn;
	private String title;
//	@OneToMany(
//			cascade = CascadeType.ALL
//	)
//	@JoinColumn(name="book_id")
//    private List<AuthorEntity> authorEntities = new ArrayList();

	private String year;
	private Double price;
	private String genre;
	
	

//	
//	public void addAuthor(AuthorEntity author) {
//		authorEntities.add(author);
//	}
//	
//	public void removeAuthor(AuthorEntity author) {
//		authorEntities.remove(author);
//	}
//	
}
