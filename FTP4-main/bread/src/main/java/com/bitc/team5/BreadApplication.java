package com.bitc.team5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;

@SpringBootApplication(exclude = {MultipartAutoConfiguration.class})
public class BreadApplication {

	public static void main(String[] args) {
		SpringApplication.run(BreadApplication.class, args);
	}

}
