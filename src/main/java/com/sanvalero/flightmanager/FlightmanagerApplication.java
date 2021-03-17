package com.sanvalero.flightmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class FlightmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightmanagerApplication.class, args);
	}

}
