package com.learning.demo.service;

import java.util.Base64;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import com.learning.demo.config.JwtUtil;
import com.learning.demo.modal.AuthUserModal;
import com.learning.demo.repository.AuthUserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AuthUserService {
	
	@Autowired
	private AuthUserRepository authUserRepository;
	@Autowired
	private JwtUtil jwtUtil;
	
	
	public String register(AuthUserModal authUserModal) {
		var encoded = Base64.getEncoder().encodeToString(authUserModal.getPassword().getBytes());
		authUserModal.setPassword(encoded);
		authUserRepository.save(authUserModal);
		return "Register success";
	}
	
	
	public Map<String, Object> login(AuthUserModal authUserModal) {
		var encoded = Base64.getEncoder().encodeToString(authUserModal.getPassword().getBytes());
		authUserModal.setPassword(encoded);
		
		AuthUserModal dbUser = authUserRepository.findByUsernameAndPassword(authUserModal.getUsername(), authUserModal.getPassword());
        if (dbUser != null) {
            var token = jwtUtil.generateToken(dbUser.getUsername());
            return Map.of("access_token", token);
        } else {
            throw new RuntimeException("Validatoin Failed");
        }
		
	}

	
	
	public AuthUserModal findByUsername(String username) {
        return authUserRepository.findByUsername(username);
    }
}
