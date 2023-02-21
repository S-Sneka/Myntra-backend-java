package com.backend.myntra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class MyntraBackendSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyntraBackendSpringBootApplication.class, args);
	}

}
