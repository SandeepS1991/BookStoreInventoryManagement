package com.BookStoreInventoryManagementSystem.bookstoremanagement.service.impl;

import com.BookStoreInventoryManagementSystem.bookstoremanagement.entity.AuthorEntity;
import com.BookStoreInventoryManagementSystem.bookstoremanagement.entity.BookEntity;
import com.BookStoreInventoryManagementSystem.bookstoremanagement.repository.AuthorRepository;
import com.BookStoreInventoryManagementSystem.bookstoremanagement.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public BookDto saveBook(BookDto bookDto) {
		logger.info("Inside the BookServiceImpl.saveBook() method.");
		try {
			BookEntity bookEntity = bookRepository.save(bookConverter.convertBookDtoToEntity(bookDto));
			for(AuthorEntity authorEntity: bookEntity.getAuthorEntitySet()) {
				authorEntity.setBookEntity(bookEntity);
				authorRepository.save(authorEntity);

			}
			
			return bookConverter.convertBookEntityToDto(bookEntity);
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public BookDto updateBook(BookDto bookDto, Long bookId) {
		
		return null;
	}

}
