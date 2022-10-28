package com.BookStoreInventoryManagementSystem.bookstoremanagement.service;

import com.BookStoreInventoryManagementSystem.bookstoremanagement.dto.BookDto;

public interface BookService {

	BookDto saveBook(BookDto bookDto);

	BookDto updateBook(BookDto bookDto, Long bookId);

}
