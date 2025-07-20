package com.learning.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.learning.demo.modal.AuthUserModal;


public interface AuthUserRepository extends JpaRepository<AuthUserModal, String> {    
	@Query(value = "SELECT * FROM authuser WHERE username=:username and password=:password", nativeQuery = true)
    AuthUserModal findByUsernameAndPassword(String username, String password);

    @Query(value = "SELECT * FROM authuser WHERE username=:username", nativeQuery = true)
    AuthUserModal findByUsername(String username);
}