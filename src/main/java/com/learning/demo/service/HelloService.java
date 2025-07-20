package com.learning.demo.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

	
	public String greeting() {
		StringBuilder sb = new StringBuilder();
		sb.append("n");
		sb.append("a");
		sb.append("m");
		sb.append("a");
		sb.append("s");
		sb.append("k");
		sb.append("a");
		sb.append("r");
		//sb.append(" ");
		return sb.toString();
	}
	
	
	public String inputOutput(String name) {
		return "Hello Mr. " + name;
	}
}
