package com.microservice.service;

import java.util.List;

import com.microservice.dto.UserDto;

public interface UserService {
	
	List<UserDto>getUsers();
	
	UserDto getUser(Long id);
	
	UserDto createUser(UserDto user);
	
	UserDto updateUser(UserDto user);
	
	void deleteUser(Long id);

}
