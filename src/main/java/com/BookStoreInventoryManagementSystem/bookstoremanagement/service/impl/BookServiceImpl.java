package com.BookStoreInventoryManagementSystem.bookstoremanagement.service.impl;

import com.BookStoreInventoryManagementSystem.bookstoremanagement.entity.AuthorEntity;
import com.BookStoreInventoryManagementSystem.bookstoremanagement.entity.BookEntity;
import com.BookStoreInventoryManagementSystem.bookstoremanagement.repository.AuthorRepository;
import com.BookStoreInventoryManagementSystem.bookstoremanagement.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookStoreInventoryManagementSystem.bookstoremanagement.converter.BookConverter;
import com.BookStoreInventoryManagementSystem.bookstoremanagement.dto.BookDto;
import com.BookStoreInventoryManagementSystem.bookstoremanagement.service.BookService;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private BookConverter bookConverter;

	@Override
	public BookDto saveBook(BookDto bookDto) {
		BookEntity bookEntity = bookRepository.save(bookConverter.convertBookDtoToEntity(bookDto));
		for(AuthorEntity authorEntity: bookEntity.getAuthorEntitySet()) {
			authorEntity.setBookEntity(bookEntity);
			authorRepository.save(authorEntity);

		}
		
		return bookConverter.convertBookEntityToDto(bookEntity);
	}
//
//	BookEntity toEntity(BookDto bookDto) {
//		BookEntity entity = new BookEntity();
//		entity.setId(bookDto.getId());
//		entity.setGenre(bookDto.getGenre());
//		entity.setIsbn(bookDto.getIsbn());
//		entity.setTitle(bookDto.getTitle());
//		entity.setYear(bookDto.getYear());
//		entity.setPrice(bookDto.getPrice());
//		return entity;
//	}
//
//	BookDto toDto(BookEntity entity) {
//		BookDto bookDto = new BookDto(entity.getIsbn(), entity.getTitle(), null,  entity.getYear(), entity.getPrice(), entity.getGenre());
//		return bookDto;
//	}

}
