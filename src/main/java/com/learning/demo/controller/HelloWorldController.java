package com.learning.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

	
	// localhost:8080/hello/world
	@GetMapping("/world")
	public String sayHello() {
		return "Hello World";
	}
	
}
