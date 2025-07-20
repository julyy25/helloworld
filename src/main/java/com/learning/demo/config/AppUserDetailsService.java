package com.learning.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.learning.demo.modal.AuthUserModal;
import com.learning.demo.service.AuthUserService;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;


@Service
public class AppUserDetailsService implements UserDetailsService {
    
	@Autowired
	private AuthUserService authUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//         User user = new User("admin", "admin", new ArrayList<>());
//         return user;

        AuthUserModal authUser = authUserService.findByUsername(username);

        if(authUser != null) {
            return new User(authUser.getUsername(), authUser.getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User doest not exist");
        }
    }
}
