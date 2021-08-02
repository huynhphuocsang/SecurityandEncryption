package com.ptit.security.ApplicationDomain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.ptit")
@SpringBootApplication
public class ApplicationDomainApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationDomainApplication.class, args);
	}

}
