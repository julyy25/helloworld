package com.learning.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	// localhost:8080/cart/items
	@GetMapping("/items")
	public String getCartItems() {
		return "CaRT ITEMS";
	}

}
