package com.ahmed.code.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ahmed.code.model.Users;

public interface UserRepository extends MongoRepository<Users, String>{

	Users findFirstByUsername(String username);
	
	@Query("{address:'?0'}")
	List<Users> findCustomByAddress(String address);
	
	@Query("{address : {$regex: ?0}}")
	List<Users> findCustomByRegExAddress(String domain);
}
