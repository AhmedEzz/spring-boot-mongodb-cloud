package com.ahmed.code.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="Foodies")
public class Users {

	@Id
	private String id;
	private String username;
	private String password;
	private String address;
	private Double salary;
	
	public Users(String username, String password, String address, Double salary) {
		this.username = username;
		this.password = password;
		this.address = address;
		this.salary = salary;
	}
	
	
}
