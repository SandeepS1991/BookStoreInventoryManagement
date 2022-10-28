package com.BookStoreInventoryManagementSystem.bookstoremanagement.converter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.BookStoreInventoryManagementSystem.bookstoremanagement.dto.AuthorDto;
import com.BookStoreInventoryManagementSystem.bookstoremanagement.dto.BookDto;
import com.BookStoreInventoryManagementSystem.bookstoremanagement.entity.AuthorEntity;
import com.BookStoreInventoryManagementSystem.bookstoremanagement.entity.BookEntity;
@Component
public class BookConverter {

	@Autowired
	AuthorConverter authorConverter;
	
	public BookEntity convertBookDtoToEntity(BookDto bookDto){
		
		BookEntity bookEntity = new BookEntity();
		
		bookEntity.setIsbn(bookDto.getIsbn());
		bookEntity.setTitle(bookDto.getTitle());
		bookEntity.setYear(bookDto.getYear());
		bookEntity.setPrice(bookDto.getPrice());
		bookEntity.setGenre(bookDto.getGenre());
		Set<AuthorEntity> authorEntities = new HashSet();		
		for(AuthorDto authorDto: bookDto.getAuthors()) {
			AuthorEntity authorEntity = new AuthorEntity();
			authorEntity = authorConverter.convertDtoToEntity(authorDto);
			authorEntities.add(authorEntity);
		}
		
		bookEntity.setAuthorEntitySet(authorEntities);
		
		return bookEntity;
		
		
		
	}
	
	public BookDto convertBookEntityToDto(BookEntity bookEntity){
		
		BookDto bookDto = new BookDto();
		bookDto.setId(bookEntity.getId());
		bookDto.setIsbn(bookEntity.getIsbn());
		bookDto.setTitle(bookEntity.getTitle());
		bookDto.setYear(bookEntity.getYear());
		bookDto.setPrice(bookEntity.getPrice());
		bookDto.setGenre(bookEntity.getGenre());
		Set<AuthorDto> authors = new HashSet();	
		
		for(AuthorEntity authorEntity: bookEntity.getAuthorEntitySet()) {
			AuthorDto authorDto = new AuthorDto();
			authorDto = authorConverter.convertEntityToDTO(authorEntity);
			authors.add(authorDto);
		}
		
		bookDto.setAuthors(authors);
		
		return bookDto;
		
		
		
	}
	
}
