package com.BookStoreInventoryManagementSystem.bookstoremanagement.converter;

import org.springframework.stereotype.Component;

import com.BookStoreInventoryManagementSystem.bookstoremanagement.dto.AuthorDto;
import com.BookStoreInventoryManagementSystem.bookstoremanagement.entity.AuthorEntity;
@Component
public class AuthorConverter {

	public AuthorEntity convertDtoToEntity(AuthorDto authorDto) {
		AuthorEntity authorEntity = new AuthorEntity();
		if(authorDto.getId() != null) {
			authorEntity.setId(authorDto.getId());
		}
		authorEntity.setName(authorDto.getName());
		authorEntity.setDateOfBirth(authorDto.getDateOfBirth());
		return authorEntity;
	}
	
	public AuthorDto convertEntityToDTO(AuthorEntity authorEntity) {
		AuthorDto authorDto = new AuthorDto();
		authorDto.setId(authorEntity.getId());
		authorDto.setName(authorEntity.getName());
		authorDto.setDateOfBirth(authorEntity.getDateOfBirth());
		return authorDto;
	}
	
	
}
