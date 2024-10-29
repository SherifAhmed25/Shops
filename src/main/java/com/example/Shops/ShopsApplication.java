package com.example.Shops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.Shops"})

public class ShopsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopsApplication.class, args);
	}

}
