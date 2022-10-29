package com.BookStoreInventoryManagementSystem.bookstoremanagement.service;

import com.BookStoreInventoryManagementSystem.bookstoremanagement.dto.BookDto;

public interface BookService {

	BookDto saveBook(BookDto bookDto);

	BookDto updateBook(BookDto bookDto, Long bookId);

	BookDto updateBookISBN(BookDto bookDto, Long bookId);

	BookDto updateBookTitle(BookDto bookDto, Long bookId);

	BookDto updateBookYear(BookDto bookDto, Long bookId);

	BookDto updateBookPrice(BookDto bookDto, Long bookId);

	BookDto updateBookGenre(BookDto bookDto, Long bookId);

	BookDto updateBookAuthor(BookDto bookDto, Long bookId);

	BookDto retrieveBook(Long bookId);

}
