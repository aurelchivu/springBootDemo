package com.aurel.springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping
	Customer getCustomer() {
		return new Customer(1L, "Aurel Chivu");
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "Aurel") String name) {
		return String.format("Hello %s!", name);
	}

	class Customer {
		private final Long id;
		private final String name;

		public Customer(Long id, String name) {
			this.id = id;
			this.name = name;
		}

		public Long getId() {
			return id;
		}

		public String getName() {
			return name;
		}
	}
}