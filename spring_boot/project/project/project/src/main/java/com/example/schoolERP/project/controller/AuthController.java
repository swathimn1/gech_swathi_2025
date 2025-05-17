package com.example.schoolERP.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

	@GetMapping({"","/"})
	public String home() {
		return "home";
	}
}
