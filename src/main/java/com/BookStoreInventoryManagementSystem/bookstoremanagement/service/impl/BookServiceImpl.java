package com.BookStoreInventoryManagementSystem.bookstoremanagement.service.impl;

import com.BookStoreInventoryManagementSystem.bookstoremanagement.entity.AuthorEntity;
import com.BookStoreInventoryManagementSystem.bookstoremanagement.entity.BookEntity;
import com.BookStoreInventoryManagementSystem.bookstoremanagement.repository.AuthorRepository;
import com.BookStoreInventoryManagementSystem.bookstoremanagement.repository.BookRepository;
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
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private BookConverter bookConverter;
	@Autowired
	private AuthorConverter authorConverter;

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
	@Transactional
	@SuppressWarnings("null")
	@Override
	public BookDto updateBook(BookDto bookDto, Long bookId) {
		
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
			return bookConverter.convertBookEntityToDto(bookRepository.save(bookEntity));

		}
		
		return null;
	}
	
//public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {
//		
//		Optional<PropertyEntity> optEnt = propertyRepository.findById(propertyId);
//		PropertyDTO pDTO =null;
//		if(optEnt.isPresent()) {
//			PropertyEntity pe = optEnt.get();
//			pe.setTitle(propertyDTO.getTitle());
//			pe.setDescription(propertyDTO.getDescription());
//			pe.setPrice(propertyDTO.getPrice());
//			pe.setAddress(propertyDTO.getAddress());
//			PropertyEntity pe_updated = propertyRepository.save(pe);
//			pDTO = propertyConverter.convertEntitytoDTO(pe_updated);
//		}
//		return pDTO;
//	}

}
