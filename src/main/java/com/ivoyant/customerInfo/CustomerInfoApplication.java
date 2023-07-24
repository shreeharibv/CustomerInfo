package com.ivoyant.customerInfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CustomerInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerInfoApplication.class, args);
	}

}
