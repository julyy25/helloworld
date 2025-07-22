package com.learning.demo.modal;

import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity(name = "message")
public class MessageModal {

	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uid;

    @NotBlank
    private String message;
    private OffsetDateTime createdAt;
    
    

	public MessageModal() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	public MessageModal(String uid, @NotBlank String message) {
		super();
		this.uid = uid;
		this.message = message;
	}




	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}




	public OffsetDateTime getCreatedAt() {
		return createdAt;
	}




	public void setCreatedAt(OffsetDateTime createdAt) {
		this.createdAt = createdAt;
	}
    
    
    

}
