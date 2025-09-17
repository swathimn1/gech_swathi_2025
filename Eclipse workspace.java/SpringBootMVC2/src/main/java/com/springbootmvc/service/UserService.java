package com.springbootmvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springbootmvc.models.User;
import com.springbootmvc.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User saveUser(User user) {

		return userRepository.save(user);
	}

	public User editUser(Long id) {
		return userRepository.findById(id).get();
	}

	public void deleteUser(Long id) {
		User user=userRepository.findById(id).get();
		userRepository.delete(user);
		
	}

}
