package com.example.tomcaterrorpage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication
public class TomcatErrorpageApplication {

	public static void main(String[] args) {
		SpringApplication.run(TomcatErrorpageApplication.class, args);
	}

}
