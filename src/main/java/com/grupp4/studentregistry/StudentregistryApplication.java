package com.grupp4.studentregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class StudentregistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentregistryApplication.class, args);
	}

}
