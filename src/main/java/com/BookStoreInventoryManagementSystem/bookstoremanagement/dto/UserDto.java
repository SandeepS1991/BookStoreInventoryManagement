package com.BookStoreInventoryManagementSystem.bookstoremanagement.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

	@NotNull(message = "UserName is mandatory.")
	@NotEmpty(message = "UserName cannot be empty.")
	@Size(min = 1, max = 50, message = "Username should be between 1 and 50 characters in length.")
	private String username;
	@NotNull(message = "Password cannot be null.")
	@NotEmpty(message = "Password cannot be empty.")
	private String password;
	@NotNull(message = "Role cannot be null.")
	@NotEmpty(message = "Role cannot be empty.")
	private String role;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	public UserDto() {
		super();
	}
	public UserDto(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	
	
}
