package com.diego.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	@RequestMapping("/api/hello")
	public String greet() {
		return "Olá mundo de uma api";
	}
}
