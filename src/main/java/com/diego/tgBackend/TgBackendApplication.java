package com.diego.tgBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.diego.controller")
public class TgBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TgBackendApplication.class, args);
	}
}
