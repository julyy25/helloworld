package com.learning.demo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class HelloServiceTest {

	@InjectMocks
	HelloService helloService;
	
	
	@Test
	void test1() {
		var output = helloService.greeting();
		Assertions.assertEquals("namaskar", output);
	}
	
	
	@Test
	void test2() {
		// dev
		var output = helloService.inputOutput("shubham");
		
		// buniess expectation
		Assertions.assertEquals("Hello Mr. shubham", output);
	}
	
}
