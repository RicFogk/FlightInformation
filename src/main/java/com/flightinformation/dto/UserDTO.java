package com.flightinformation.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.flightinformation.controllers.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String firstName;
	private String LastName;
	private String email;
	//Senha retirada para nao transitar no DTO
	
	Set<RoleDTO> roles = new HashSet<>();
	
	
	public UserDTO() {
	}

	public UserDTO(Long id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		LastName = lastName;
		this.email = email;
		
	}
	
	public UserDTO(User entity) {
		super();
		id = entity.getId();
		firstName = entity.getFirstName();
		LastName = entity.getLastName();
		email = entity.getEmail();
		entity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<RoleDTO> getRoles() {
		return roles;
	}
	
	
}
