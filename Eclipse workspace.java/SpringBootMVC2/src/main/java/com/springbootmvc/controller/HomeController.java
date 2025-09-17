package com.springbootmvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springbootmvc.models.User;
import com.springbootmvc.repository.UserRepository;
import com.springbootmvc.service.UserService;

@Controller
public class HomeController {
	private final UserService userService;
	private final UserRepository userRepository;

	public HomeController(UserService userService, UserRepository userRepository) {
		super();
		this.userService = userService;
		this.userRepository = userRepository;
	}

	@GetMapping({ "/", "/users" })
	public String getAllUsers(Model model) {
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "home";
	}

	@GetMapping({ "/users/add" })
	public String addUser(Model model) {
		model.addAttribute("user", new User());
		return "add_user";
	}

//	@PostMapping({ "/users/save" })
//	public String saveUser(@ModelAttribute("user") User user) {
//		userService.saveUser(user);
//		return "redirect:/users";
//
//	}
	@PostMapping("/users/add")
	public String saveUser(@ModelAttribute("user") User user) {
	    userService.saveUser(user);
	    return "redirect:/users";  // after saving, redirect to the user list
	}


	@GetMapping("/users/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        User user = userService.editUser(id); // fetch from DB
        model.addAttribute("user", user);
        return "edit_user"; // edit_user.html
    }

//	@PostMapping("/edit{id}")
//	public String UpdateUser(@RequestParam Long id, User user,@ModelAttribute("user")  ) {
////		User user=userRepository.findById(id).get();
//		userService.updateStudent(id);
//		return "redirect:/users";
//		
//	}

	@GetMapping("/users/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
	    userService.deleteUser(id);
	    return "redirect:/users";
	}


}
