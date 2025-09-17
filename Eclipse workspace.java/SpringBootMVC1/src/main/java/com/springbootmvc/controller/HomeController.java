package com.springbootmvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springbootmvc.models.User;
import com.springbootmvc.repository.Userrepository;

@Controller // -->it will return a views or templates or front end part
//@RestController // it will return a string
public class HomeController {

	private final Userrepository userRepository;

	public HomeController(Userrepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@GetMapping({ "/", "/home" })
	public String home(Model model) {
		List<User> users = userRepository.findAll();
		model.addAttribute("users", users);

		return "home";
	}

	@GetMapping({ "/about" })
	public String about() {
		return "about";
	}

	@GetMapping({ "/contact" })
	public String contact() {
		return "contact";
	}

	@GetMapping({ "/service" })
	public String service() {
		return "service";
	}

}
