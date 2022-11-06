package com.BookStoreInventoryManagementSystem.bookstoremanagement.service.impl;

import com.BookStoreInventoryManagementSystem.bookstoremanagement.entity.AuthorEntity;
import com.BookStoreInventoryManagementSystem.bookstoremanagement.entity.BookEntity;
import com.BookStoreInventoryManagementSystem.bookstoremanagement.entity.UserEntity;
import com.BookStoreInventoryManagementSystem.bookstoremanagement.exception.BusinessException;
import com.BookStoreInventoryManagementSystem.bookstoremanagement.exception.ErrorModel;
import com.BookStoreInventoryManagementSystem.bookstoremanagement.repository.AuthorRepository;
import com.BookStoreInventoryManagementSystem.bookstoremanagement.repository.BookRepository;
import com.BookStoreInventoryManagementSystem.bookstoremanagement.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BookStoreInventoryManagementSystem.bookstoremanagement.converter.AuthorConverter;
import com.BookStoreInventoryManagementSystem.bookstoremanagement.converter.BookConverter;
import com.BookStoreInventoryManagementSystem.bookstoremanagement.dto.AuthorDto;
import com.BookStoreInventoryManagementSystem.bookstoremanagement.dto.BookDto;
import com.BookStoreInventoryManagementSystem.bookstoremanagement.service.BookService;

@RequiredArgsConstructor
@Transactional
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BookConverter bookConverter;
	@Autowired
	private AuthorConverter authorConverter;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public BookDto saveBook(BookDto bookDto) {
		logger.info("Inside the BookServiceImpl.saveBook() method.");
//		try {
			Optional<BookEntity> optEnt = bookRepository.findByIsbn(bookDto.getIsbn());
			
			if(!optEnt.isPresent()) {
			BookEntity bookEntity = bookRepository.save(bookConverter.convertBookDtoToEntity(bookDto));
				for(AuthorEntity authorEntity: bookEntity.getAuthorEntitySet()) {
					authorEntity.setBookEntity(bookEntity);
					authorRepository.save(authorEntity);
	
				}
			
			return bookConverter.convertBookEntityToDto(bookEntity);
			}
			else {
				logger.error("Book with this ISBN already exists.");
				List<ErrorModel> errorModelList = new ArrayList<>();
				ErrorModel errorModel = new ErrorModel();
				errorModel.setCode("ISBN ALREADY EXISTS");
				errorModel.setMessage("Book with this ISBN already exists." );
				errorModelList.add(errorModel);
				
				throw new BusinessException(errorModelList);
			}
			
//		} catch (Exception e) {
//			logger.error("Exception occurred: " + e.getMessage());
//			e.printStackTrace();
//			List<ErrorModel> errorModelList = new ArrayList<>();
//			ErrorModel errorModel = new ErrorModel();
//			errorModel.setCode("EXCEPTION OCCURRED");
//			errorModel.setMessage("Exception occurred while saving new book.");
//			errorModelList.add(errorModel);
//			
//			throw new BusinessException(errorModelList);
//
//		}
		
	}
	@Transactional
	@SuppressWarnings("null")
	@Override
	public BookDto updateBook(BookDto bookDto, Long bookId) {
		logger.info("Inside the BookServiceImpl.updateBook() method. START");
		try {
			Optional<BookEntity> optBookEntity = bookRepository.findById(bookId);
			if(optBookEntity.isPresent()) {
				BookEntity bookEntity = optBookEntity.get();
				bookEntity.setId(bookId);
				bookEntity.setIsbn(bookDto.getIsbn());
				bookEntity.setTitle(bookDto.getTitle());
				bookEntity.setYear(bookDto.getYear());
				bookEntity.setPrice(bookDto.getPrice());
				bookEntity.setGenre(bookDto.getGenre());
				
				List<AuthorEntity> authorEntityList = new ArrayList<>();
				for(AuthorDto authordto: bookDto.getAuthors()) {

					Optional<AuthorEntity> optAuthorEntity = authorRepository.findById(authordto.getId());
					if(optAuthorEntity.isPresent()) {
						AuthorEntity authorEntity = authorConverter.convertDtoToEntity(authordto);

						authorEntity.setBookEntity(bookEntity);
						authorEntity = authorRepository.save(authorEntity);
						authorEntityList.add(authorEntity);
					}
				}
				Set<AuthorEntity> authorEntitySet = new HashSet<>(authorEntityList);
				bookEntity.setAuthorEntitySet(authorEntitySet);
				logger.info("Inside the BookServiceImpl.updateBook() method. END");
				return bookConverter.convertBookEntityToDto(bookRepository.save(bookEntity));

			}
			else {
				logger.error("Inside the BookServiceImpl.updateBook() method. No ");
				List<ErrorModel> errorModelList = new ArrayList<>();
				ErrorModel errorModel = new ErrorModel();
				errorModel.setCode("INVALID_BOOK_ID");
				errorModel.setMessage("No Records found to update with this book id: " + bookId);
				errorModelList.add(errorModel);
				
				throw new BusinessException(errorModelList);
				
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			logger.error("Inside the BookServiceImpl.updateBook() method. No ");
			List<ErrorModel> errorModelList = new ArrayList<>();
			ErrorModel errorModel = new ErrorModel();
			errorModel.setCode("INVALID_BOOK_ID");
			errorModel.setMessage("No Records found to update with this book id: " + bookId);
			errorModelList.add(errorModel);
			
			throw new BusinessException(errorModelList);
		}
		
	}
	
	@Override
	public BookDto updateBookISBN(BookDto bookDto, Long bookId) {
		Optional<BookEntity> optBookEntity = bookRepository.findById(bookId);
		if(optBookEntity.isPresent()) {
			BookEntity bookEntity = optBookEntity.get();
			bookEntity.setIsbn(bookDto.getIsbn());
			return bookConverter.convertBookEntityToDto(bookRepository.save(bookEntity));
		}
		else {
			logger.error("Inside the BookServiceImpl.updateBook() method. No ");
			List<ErrorModel> errorModelList = new ArrayList<>();
			ErrorModel errorModel = new ErrorModel();
			errorModel.setCode("INVALID_BOOK_ID");
			errorModel.setMessage("No Records found to update with this book id: " + bookId);
			errorModelList.add(errorModel);
			
			throw new BusinessException(errorModelList);	
		}
		

	}
	
	@Override
	public BookDto updateBookTitle(BookDto bookDto, Long bookId) {

		Optional<BookEntity> optBookEntity = bookRepository.findById(bookId);
		if(optBookEntity.isPresent()) {
			BookEntity bookEntity = optBookEntity.get();
			bookEntity.setTitle(bookDto.getTitle());
			return bookConverter.convertBookEntityToDto(bookRepository.save(bookEntity));
		}
		return null;
	}
	
	@Override
	public BookDto updateBookYear(BookDto bookDto, Long bookId) {
		Optional<BookEntity> optBookEntity = bookRepository.findById(bookId);
		if(optBookEntity.isPresent()) {
			BookEntity bookEntity = optBookEntity.get();
			bookEntity.setYear(bookDto.getYear());
			return bookConverter.convertBookEntityToDto(bookRepository.save(bookEntity));
		}
		return null;
	}
	
	@Override
	public BookDto updateBookPrice(BookDto bookDto, Long bookId) {
		Optional<BookEntity> optBookEntity = bookRepository.findById(bookId);
		if(optBookEntity.isPresent()) {
			BookEntity bookEntity = optBookEntity.get();
			bookEntity.setPrice(bookDto.getPrice());
			return bookConverter.convertBookEntityToDto(bookRepository.save(bookEntity));
		}
		return null;
	}
	
	@Override
	public BookDto updateBookGenre(BookDto bookDto, Long bookId) {
		Optional<BookEntity> optBookEntity = bookRepository.findById(bookId);
		if(optBookEntity.isPresent()) {
			BookEntity bookEntity = optBookEntity.get();
			bookEntity.setGenre(bookDto.getGenre());
			return bookConverter.convertBookEntityToDto(bookRepository.save(bookEntity));
		}
		return null;
	}
	
	@Override
	public BookDto updateBookAuthor(BookDto bookDto, Long bookId) {
		Optional<BookEntity> optBookEntity = bookRepository.findById(bookId);
		if(optBookEntity.isPresent()) {
			BookEntity bookEntity = optBookEntity.get();
			List<AuthorEntity> authorEntityList = new ArrayList<>();
			for(AuthorDto authordto: bookDto.getAuthors()) {
				Optional<AuthorEntity> optAuthorEntity = authorRepository.findById(authordto.getId());
				if(optAuthorEntity.isPresent()) {
					AuthorEntity authorEntity = authorConverter.convertDtoToEntity(authordto);
					authorEntity.setBookEntity(bookEntity);
					authorEntity = authorRepository.save(authorEntity);
					authorEntityList.add(authorEntity);
				}
			}
			Set<AuthorEntity> authorEntitySet = new HashSet<>(authorEntityList);
			bookEntity.setAuthorEntitySet(authorEntitySet);
			return bookConverter.convertBookEntityToDto(bookRepository.save(bookEntity));
		}
		return null;
	}
	
	@Override
	public void deleteBook(Long bookId, String userName) {
		//yet to implement role based deletion
		//need to retrieve authors for this book and delete as well
		UserEntity userEntity = userRepository.findByUsername(userName);
		if(userEntity.getRole().equalsIgnoreCase("Admin")) {
			int numAuthorRowsDeleted = authorRepository.deleteByBookIdNative(bookId);
			if(numAuthorRowsDeleted != 0) {
				bookRepository.deleteById(bookId);
			}
			
		}
		
	}
	
	@Override
	public List<BookDto> retrieveBookByTitleOrName(String title, String authorName) {
		List<BookDto> bookDtoList = new ArrayList<>();
		if (!title.isEmpty() && !authorName.isEmpty()) {
			List<AuthorEntity> authorList = authorRepository.findByNameEquals(authorName);
			if(!authorList.isEmpty()){
				for(AuthorEntity authorE: authorList) {
					Optional<BookEntity> optBookEntity = bookRepository.findByIdAndTitle(authorE.getBookEntity().getId(), title);
					if(optBookEntity.isPresent()) {
						BookDto bookDto = bookConverter.convertBookEntityToDto(optBookEntity.get());
						bookDtoList.add(bookDto);
					}
			}
				
			}
		}
		else if(!title.isEmpty()) {
			Optional<List<BookEntity>> optBookEntity = bookRepository.findByTitle(title);
			if(optBookEntity.isPresent()){
				for(BookEntity bookEnt: optBookEntity.get()) {
					BookDto bookDto = bookConverter.convertBookEntityToDto(bookEnt);
					bookDtoList.add(bookDto);
				}
			}
		}
		else if(!authorName.isEmpty()) {
			List<AuthorEntity> authorList = authorRepository.findByNameEquals(authorName);
			if(!authorList.isEmpty()){
				for(AuthorEntity authorE: authorList) {
					Optional<BookEntity> optBookEntity = bookRepository.findById(authorE.getBookEntity().getId());
					if(optBookEntity.isPresent()) {
						BookDto bookDto = bookConverter.convertBookEntityToDto(optBookEntity.get());
						bookDtoList.add(bookDto);
					}
			}
				
			}
		}
		else {
			//throw exception
		}
		
		return bookDtoList;
		
	}

}
