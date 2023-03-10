package com.adtech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;



@SpringBootApplication
@EnableScheduling
public class AdTechApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdTechApplication.class, args);
	}

}
