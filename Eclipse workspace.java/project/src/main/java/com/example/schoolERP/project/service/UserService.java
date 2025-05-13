package com.example.schoolERP.project.service;

import org.springframework.stereotype.Service;

import com.example.schoolERP.project.model.User;

@Service
public interface UserService {
    boolean authenticate(String username, String password);

	User findUserByUsername(String username);
}

	
