package com.BookStoreInventoryManagementSystem.bookstoremanagement.service.impl;

import com.BookStoreInventoryManagementSystem.bookstoremanagement.entity.BookEntity;
import com.BookStoreInventoryManagementSystem.bookstoremanagement.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookStoreInventoryManagementSystem.bookstoremanagement.dto.BookDto;
import com.BookStoreInventoryManagementSystem.bookstoremanagement.service.BookService;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
	private final BookRepository bookRepository = null;

	@Override
	public BookDto saveBook(BookDto bookDto) {
		BookEntity bookEntity = bookRepository.save(toEntity(bookDto));
		return null;
	}

	BookEntity toEntity(BookDto bookDto) {
		BookEntity entity = new BookEntity();
		entity.setId(bookDto.getId());
		entity.setGenre(bookDto.getGenre());
		entity.setIsbn(bookDto.getIsbn());
		entity.setTitle(bookDto.getTitle());
		entity.setYear(bookDto.getYear());
		entity.setPrice(bookDto.getPrice());
		return entity;
	}

	BookDto toDto(BookEntity entity) {
		BookDto bookDto = new BookDto(entity.getIsbn(), entity.getTitle(), null,  entity.getYear(), entity.getPrice(), entity.getGenre());
		return bookDto;
	}

}
