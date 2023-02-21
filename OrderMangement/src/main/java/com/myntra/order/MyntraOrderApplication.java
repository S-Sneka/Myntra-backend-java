package com.myntra.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MyntraOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyntraOrderApplication.class, args);
	}
}
