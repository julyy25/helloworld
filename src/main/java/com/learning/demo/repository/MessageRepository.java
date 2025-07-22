package com.learning.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.learning.demo.modal.AuthUserModal;
import com.learning.demo.modal.MessageModal;


public interface MessageRepository extends JpaRepository<MessageModal, String> {    
	
}