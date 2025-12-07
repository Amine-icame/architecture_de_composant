package com.example.tpioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = "com.example.tpioc")
public class TpiocApplication {

	// Injection par Factory
	@org.springframework.context.annotation.Bean
	public com.example.tpioc.dao.IDao getDao() {
		return new com.example.tpioc.dao.DaoImpl1();
	}
	/*public static void main(String[] args) {
		SpringApplication.run(TpiocApplication.class, args);
	}*/

}
