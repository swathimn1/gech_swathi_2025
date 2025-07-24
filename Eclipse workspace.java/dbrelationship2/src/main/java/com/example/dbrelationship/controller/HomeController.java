package com.example.dbrelationship.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.dbrelationship.model.Employee;
import com.example.dbrelationship.service.AuthService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    private final AuthService authService;

    public HomeController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping({"", "/", "/dashboard"})
    public String dashboard(HttpServletRequest request, Model model) {
        String success_msg = (String) request.getSession().getAttribute("success");
        if (success_msg != null) {
            model.addAttribute("success", success_msg);
            request.getSession().removeAttribute("success");
        }
        return "dashboard";
    }

//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }

//    @GetMapping("/register")
//    public String registration(Model model) {
//        model.addAttribute("employeeDTO", new EmployeeDTO());
//        return "registration";
//    }
//
//    @PostMapping("/register")
//    public String processRegistration(@Valid @ModelAttribute("employeeDTO") EmployeeDTO employeeDTO,
//                                      BindingResult result,
//                                      Model model,
//                                      HttpServletRequest request) {
//        if (result.hasErrors()) {
//            return "registration";
//        }
//
//        authService.registerUser(employeeDTO);
//        request.getSession().setAttribute("success", "Registration successful!");
//        return "redirect:/dashboard";
//    }

    @GetMapping("/403")
    public String accessDenied() {
        return "403";
    }

    @GetMapping("/profile")
    public String profile(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        Employee employee = authService.findByEmail(userDetails.getUsername());
        model.addAttribute("employee", employee);
        return "profile";
    }

}
