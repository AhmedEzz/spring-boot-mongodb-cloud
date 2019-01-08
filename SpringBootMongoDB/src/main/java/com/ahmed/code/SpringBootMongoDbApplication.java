package com.ahmed.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ahmed.code.model.Users;
import com.ahmed.code.repository.CustomRepository;
import com.ahmed.code.repository.UserRepository;

@SpringBootApplication
public class SpringBootMongoDbApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CustomRepository customRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongoDbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		deleteAll();
		addSampleData();
		listAll();
		findFirst();
		findByRegex();
	}

	public void deleteAll() {
		System.out.println("Deleting all records..");
		userRepository.deleteAll();
	}

	public void addSampleData() {
		System.out.println("Adding sample data");
		userRepository.save(new Users("Jack Bauer", "jack123", "New York", 11111d));
		userRepository.save(new Users("Harvey Spectre", "harvey123", "London", 22222d));
		userRepository.save(new Users("Mike Ross", "mike123", "New Jersey", 333333d));
		userRepository.save(new Users("Louise Litt", "louise123", "Kathmandu", 44444d));
	}

	public void listAll() {
		System.out.println("Listing sample data");
		userRepository.findAll().forEach(u -> System.out.println(u));
	}

	public void findFirst() {
		System.out.println("Finding first by Name");
		Users u = userRepository.findFirstByUsername("Louise Litt");
		System.out.println(u);
	}

	public void findByRegex() {
		System.out.println("Finding by Regex - All with address starting with ^New");
		userRepository.findCustomByRegExAddress("^New").forEach(u -> System.out.println(u));
	}
}
