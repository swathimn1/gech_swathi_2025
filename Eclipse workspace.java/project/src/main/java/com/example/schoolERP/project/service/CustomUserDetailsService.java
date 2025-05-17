package com.example.schoolERP.project.service;
import com.example.schoolERP.project.model.User;
import com.example.schoolERP.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Using Optional to safely handle user not found scenario
    	User user = userRepository.findByUsername(username)
    	        .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));


        // Building the UserDetails object for Spring Security
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole())  // Make sure role is like "ADMIN" without "ROLE_" prefix
                .build();
    }
}


