package com.Test;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Employee Management System Project   ",
		description = "Employee Management System ,  Assignment For Compnay",contact = @Contact(name = "nikhil",email = "nikhiln2@gmail.com")))

public class Project2Application {

	public static void main(String[] args) {
		SpringApplication.run(Project2Application.class, args);
	}

}
