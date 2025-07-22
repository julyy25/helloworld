package com.learning.demo.service;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.learning.demo.modal.MessageModal;
import com.learning.demo.repository.MessageRepository;


@Service
public class MessageService {
	
	@Autowired
	MessageRepository messageRepository;
	
	
	public String createMessage(MessageModal messageModal) {
		messageModal.setCreatedAt(OffsetDateTime.now());
		 messageRepository.save(messageModal);
		 return "success";
	}
	
	
	public List<MessageModal> readAllMessage() {
		return messageRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
	}

}
