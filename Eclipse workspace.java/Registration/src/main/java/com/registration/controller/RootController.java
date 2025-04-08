package com.registration.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class RootController {
	@GetMapping("/")
	public String rootRedirect() {
		return "redirect:/registration/register";
	}
}


