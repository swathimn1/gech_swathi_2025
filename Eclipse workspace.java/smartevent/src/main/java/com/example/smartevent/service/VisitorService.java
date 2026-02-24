package com.example.smartevent.service;

import com.example.smartevent.models.User;
import com.example.smartevent.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VisitorService {

    private final UserRepository userRepository;
    

    public VisitorService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	public Long getVisitorIdByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + username));
        return user.getId(); // Assuming User id is used as visitorId
    }
}