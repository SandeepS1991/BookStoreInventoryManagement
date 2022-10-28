package com.BookStoreInventoryManagementSystem.bookstoremanagement.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BookStoreInventoryManagementSystem.bookstoremanagement.dto.BookDto;
import com.BookStoreInventoryManagementSystem.bookstoremanagement.service.BookService;


@RestController
@RequestMapping("/book")
public class BookController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BookService bookService;
	
	@PostMapping("/addNewBook")
	public ResponseEntity<BookDto> saveBook(@RequestBody BookDto bookDto) {
		logger.info("Inside the save book controller method.");
		BookDto bookDTO = bookService.saveBook(bookDto);
		ResponseEntity<BookDto> responseEntity = new ResponseEntity<>(bookDTO, HttpStatus.CREATED);
		return responseEntity;
		
	}
	
	@PutMapping("/updateBook/{bookId}")
	public ResponseEntity<BookDto> updateBook(@RequestBody BookDto bookDto,@PathVariable Long bookId) {
		
		bookDto = bookService.updateBook(bookDto, bookId);
		ResponseEntity<BookDto> responseEntity = new ResponseEntity<>(bookDto, HttpStatus.OK);
		return responseEntity;
		
	}
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello!";
	}
	
}
