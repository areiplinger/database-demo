package com.in28minutes.database.databasedemo;


import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;


//@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Fire the query

		logger.info("Finding User 10022 -> {}", repository.findById(10022));

		logger.info("Inserting Dexter Morgan -> {}", repository.insert(
				new Person("Dexter Morgan", "Miami",
						new Date())));

		logger.info("Updating Jane Doe to Deborah Morgan -> {}", repository.update(
				new Person(10022, "Deborah Morgan", "Miami",
						new Date())));

		repository.deleteById(10021);

		logger.info("All users -> {}", repository.findAll());

		/*logger.info("Finding User ID's starting with 100 -> {}", repository.findByLikeId(100));

		logger.info("Finding user John Smith -> {}", repository.findByName("JOHN SMITH"));

		logger.info("Deleting User 10021 -> {}", repository.deleteById(10021));*/
	}
}
