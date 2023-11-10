package com.ankur.oktademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.ankur.*")
public class OktademoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OktademoApplication.class, args);
	}

}
