package com.lms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LmsApplication {
  
	public static void main(String[] args) {
		System.out.println("added for bug");
		SpringApplication.run(LmsApplication.class, args);
		System.out.println("added for bug too");
	}
}
