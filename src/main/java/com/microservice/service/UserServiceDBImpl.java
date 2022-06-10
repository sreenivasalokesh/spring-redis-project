package com.microservice.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.microservice.controller.UserController;
import com.microservice.dto.UserDto;

@Component
public class UserServiceDBImpl implements UserService{
	

	private static Logger log = LoggerFactory.getLogger(UserController.class);
	
	List<UserDto> users = new ArrayList<UserDto>();
	
	private static Long id =1L;

	@Override
	public List<UserDto> getUsers() {
		log.info("Get Users Service");
		return users;
	}

	@Override
	public UserDto getUser(Long id) {
		log.info("Get User Service");
		for(UserDto user : users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	@Override
	public UserDto createUser(UserDto user) {
		log.info("create Users Service");
		 user.setId(UserServiceDBImpl.id++);
		 users.add(user);
		 return user;
	}

	@Override
	public UserDto updateUser(UserDto user) {
		log.info("update Users Service");
		users.remove(user);
		users.add(user);
		return user;
	}

	@Override
	public void deleteUser(Long id) {
		log.info("delete User Service");
		UserDto user = null;
		
		for(UserDto u : users) {
			if(u.getId() == id) {
				user = u;
				break;
			}
		}
		
		if(user != null) {
			users.remove(user);
		}
	}

}
