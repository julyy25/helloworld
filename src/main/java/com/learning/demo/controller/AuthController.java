package com.learning.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.demo.modal.AuthUserModal;
import com.learning.demo.service.AuthUserService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private AuthUserService authUserService;

	// localhost:8080/auth/register
	@PostMapping("/register")
	public String register(@RequestBody AuthUserModal authUserModel) {
		return authUserService.register(authUserModel);
	}
	
	
	@PostMapping("/login")
	public Map login(@RequestBody AuthUserModal authUserModel) {
		
		return authUserService.login(authUserModel);
	}
}
