package com.registration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

	@GetMapping("/")
	public String rootRedirect() {
		return "redirect:/registration/register";
	}
}
