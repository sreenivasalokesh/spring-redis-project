package com.microservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.dto.UserDto;
import com.microservice.service.UserService;

@RestController

public class UserController {
	
	private static Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;
	
	@GetMapping(path = "/users")
	@Cacheable(cacheNames = "users")
	public List<UserDto> users(){
		log.info("###Get Users");
		return userService.getUsers();
	}
	
	@GetMapping(path = "/user/{id}")
	@Cacheable(cacheNames = "users", key="#id")
	public UserDto user(@PathVariable Long id) {
		log.info("###Get Users: "+id);
		return userService.getUser(id);
	}
	
	@PostMapping(path = "/create/user")	
	@CacheEvict(cacheNames = "users" , allEntries = true)
	public UserDto create(@RequestBody UserDto user){
		log.info("###Create User");
		return userService.createUser(user);
	}
	
	@PostMapping(path = "/update/user/{id}")
	@CachePut(cacheNames="users", key="#id")
	public UserDto update(@RequestBody UserDto user, @PathVariable Long id) {
		log.info("###Update Users: "+user.getId());
		return userService.updateUser(user);
	}
	
	@PostMapping(path = "/delete/user/{id}")
	@CacheEvict(cacheNames = "users", key="#id")
	public void delete(@PathVariable Long id) {
		log.info("###Delete Users: "+id);
		userService.deleteUser(id);
	}
}
