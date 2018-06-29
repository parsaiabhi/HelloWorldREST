package com.matrix.rest.service.HelloWorldRESTservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.matrix.rest"})
public class HelloWorldResTserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldResTserviceApplication.class, args);
	}
}
