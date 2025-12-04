package com.example.smartevent.controller;

import com.example.smartevent.models.User;
import com.example.smartevent.service.VisitorRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/visitors")
@RequiredArgsConstructor
public class VisitorController {

    private final VisitorRegistrationService registrationService;

    public VisitorController(VisitorRegistrationService registrationService) {
		super();
		this.registrationService = registrationService;
	}

	@PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) throws Exception {
        User saved = registrationService.registerVisitor(user);
        return ResponseEntity.ok(saved);
    }
}
