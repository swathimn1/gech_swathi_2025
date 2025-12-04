package com.example.smartevent.service;

import com.example.smartevent.models.Role;
import com.example.smartevent.models.User;
import com.example.smartevent.repository.UserRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VisitorRegistrationService {

    private final UserRepository userRepository;
    private final EmailService emailService;
    

    public VisitorRegistrationService(UserRepository userRepository, EmailService emailService) {
		super();
		this.userRepository = userRepository;
		this.emailService = emailService;
	}


	public User registerVisitor(User user) throws Exception {
		 user.setRole(Role.VISITOR);
        user.setTotalPoints(user.getTotalPoints() == null ? 0 : user.getTotalPoints());
        User saved = userRepository.save(user);

        emailService.sendEmail(
                saved.getEmail(),
                "Welcome to Smart Event!",
                "welcome-visitor.html",
                new String[][]{
                        {"{{name}}", saved.getFullName()}
                }
        );

        return saved;
    }
}
