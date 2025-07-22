package com.learning.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.demo.modal.MessageModal;
import com.learning.demo.service.MessageService;

@RestController
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	MessageService messageService;
	
	// localhost:8080/message/create
	@PostMapping("/create")
	public String createMessage(@RequestBody MessageModal messageModal) {
		
		return messageService.createMessage(messageModal);
	}
	
	
	@GetMapping("/readall")
	public List<MessageModal> readAllMessage() {
		return messageService.readAllMessage();
	}

}
