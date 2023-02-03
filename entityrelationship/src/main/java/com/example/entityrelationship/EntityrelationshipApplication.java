package com.example.entityrelationship;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
//@EnableJpaRepositories("com.example.entityrelationship.repository")
@SpringBootApplication
public class EntityrelationshipApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntityrelationshipApplication.class, args);
	}

}
