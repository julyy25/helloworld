package com.learning.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	// localhost:8080/order/hello
	@GetMapping("/heloo")
	public String hello() {
		return "IAMORDER CONTROLLER";
	}

}
