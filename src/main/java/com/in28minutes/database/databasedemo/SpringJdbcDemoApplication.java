package com.in28minutes.database.databasedemo;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;


//@SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Fire the query
		logger.info("All users -> {}", dao.findAll());

		logger.info("Finding User 10022 -> {}", dao.findById(10022));

        logger.info("Finding User ID's starting with 100 -> {}", dao.findByLikeId(100));

		logger.info("Finding user John Smith -> {}", dao.findByName("JOHN SMITH"));

		logger.info("Inserting Dexter Morgan -> {}", dao.insertValues(
				new Person(10023, "Dexter Morgan", "Miami",
						new Date())));

		logger.info("Updating Jane Doe to Deborah Morgan -> {}", dao.updateValues(
				new Person(10022, "Deborah Morgan", "Miami",
						new Date())));

		logger.info("Deleting User 10021 -> {}", dao.deleteById(10021));
	}
}
