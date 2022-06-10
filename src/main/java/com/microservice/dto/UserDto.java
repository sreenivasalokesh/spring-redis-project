package com.microservice.dto;

import java.io.Serializable;


public class UserDto implements Serializable{
	
	private Long id;
	
	private String name;
	
	private String email;
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof UserDto)) {
			return false;
		}
		UserDto user = (UserDto) obj;
		
		if(this.id != user.getId()) {
			return false;
		}else if(!this.getName().equals(user.getName())) {
			return false;
		}else if(!this.getEmail().equals(user.getName())) {
			return false;
		}
		return true;
	}
	

	public UserDto(Long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	@Override
	public String toString() {
		return id + " : " + name + " : "  + email;
	}
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
