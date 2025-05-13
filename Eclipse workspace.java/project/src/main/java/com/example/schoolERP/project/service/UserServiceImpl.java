package com.example.schoolERP.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.schoolERP.project.model.User;
import com.example.schoolERP.project.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean authenticate(String username, String password) {
		return false;
        // implementation here
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username); // assuming your repo has this method
    }
}
