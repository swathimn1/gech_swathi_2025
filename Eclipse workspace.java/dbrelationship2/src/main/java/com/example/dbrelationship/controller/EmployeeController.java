package com.example.dbrelationship.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.dbrelationship.dto.EmployeeDTO;
import com.example.dbrelationship.dto.OnCreate;
import com.example.dbrelationship.dto.TaskDTO;
import com.example.dbrelationship.model.Employee;
import com.example.dbrelationship.model.Roles;
import com.example.dbrelationship.repository.DepartmentsRepository;
import com.example.dbrelationship.repository.EmployeeRepository;
import com.example.dbrelationship.repository.RolesRepository;
import com.example.dbrelationship.service.AuthService;
import com.example.dbrelationship.service.TaskService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    private final RolesRepository rolesRepository;
    private final DepartmentsRepository departmentRepository;
    private final AuthService authService;
    private final TaskService  taskService;

    

    // ✅ List all employees
    @GetMapping({"/employees"})
    public String listEmployees(Model model) {
    	 List<Employee> employees = employeeRepository.findAll();
         model.addAttribute("employees", employees);
         return "employees"; 
    }

    // ✅ Show form to add employee
//    @GetMapping("/employees/add")
//    public String showAddForm(Model model) {
//        model.addAttribute("employeeDTO", new EmployeeDTO());
//        model.addAttribute("roles", rolesRepository.findAll());
//        model.addAttribute("departments", departmentRepository.findAll());
//        return "add-employee"; // Template: add-employee.html
//    }

    public EmployeeController(EmployeeRepository employeeRepository, RolesRepository rolesRepository,
			DepartmentsRepository departmentRepository, AuthService authService, TaskService taskService) {
		super();
		this.employeeRepository = employeeRepository;
		this.rolesRepository = rolesRepository;
		this.departmentRepository = departmentRepository;
		this.authService = authService;
		this.taskService = taskService;
	}

	// ✅ Save employee
    @GetMapping("/employees/add")
    public String showAddForm(Model model) {
        model.addAttribute("employeeDTO", new EmployeeDTO());
        model.addAttribute("roles", rolesRepository.findAll());
        model.addAttribute("departments", departmentRepository.findAll());
        return "add-employee";
    }

    @PostMapping("/employees/add")
    public String saveEmployee(@Valid @ModelAttribute("employeeDTO") EmployeeDTO employeeDTO,
                               BindingResult result,
                               RedirectAttributes attributes,
                               Model model) {
        if (employeeDTO.getDepartmentId() == null) {
            result.addError(new FieldError("employeeDTO", "departmentId", "Department is required"));
        }

        if (employeeDTO.getRoles().isEmpty()) {
            result.addError(new FieldError("employeeDTO", "roles", "At least one role must be selected."));
        }

        if (result.hasErrors()) {
            model.addAttribute("roles", rolesRepository.findAll());
            model.addAttribute("departments", departmentRepository.findAll());
            return "add-employee";
        }

        Employee savedEmployee = authService.saveEmployee(employeeDTO);

        if (employeeDTO.getTaskTitles() != null) {
            for (int i = 0; i < employeeDTO.getTaskTitles().size(); i++) {
                String title = employeeDTO.getTaskTitles().get(i);
                String desc = i < employeeDTO.getTaskDescriptions().size() ? employeeDTO.getTaskDescriptions().get(i) : "";
                taskService.saveTaskForEmployee(savedEmployee.getId(), title, desc);
            }
        }

        attributes.addFlashAttribute("success", "Employee with tasks added successfully!");
        return "redirect:/employees";
    }


    @PostMapping("/employees/delete/{id}")
    public String deleteEmployee(@PathVariable Long id, RedirectAttributes attributes) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty()) {
            attributes.addFlashAttribute("error", "Employee not found");
            return "redirect:/employees";
        }

        for (var role : employee.get().getRoles()) {
            role.getEmployees().remove(employee.get());
        }

        try {
            employeeRepository.delete(employee.get());
            attributes.addFlashAttribute("success", "Employee deleted successfully");
        } catch (Exception e) {
            attributes.addFlashAttribute("error", "Error deleting employee: " + e.getMessage());
        }

        return "redirect:/employees";
    }


    // ✅ Edit employee
    @GetMapping("/employees/edit/{id}")
    public String editEmployee(@PathVariable Long id, Model model, RedirectAttributes attributes) {
        Optional<Employee> employeeOpt = employeeRepository.findById(id);
        if (employeeOpt.isEmpty()) {
            attributes.addFlashAttribute("error", "Employee not found");
            return "redirect:/employees";
        }

        Employee employee = employeeOpt.get();
        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setName(employee.getName());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setPassword(employee.getPassword());

        // Set address fields
        EmployeeDTO.AddressDTO addressDTO = new EmployeeDTO.AddressDTO();
        if (employee.getAddress() != null) {
            addressDTO.setStreet(employee.getAddress().getStreet());
            addressDTO.setCity(employee.getAddress().getCity());
            addressDTO.setState(employee.getAddress().getState());
        }
        employeeDTO.setAddress(addressDTO);

        // Set roles
        employeeDTO.setRoles(employee.getRoles().stream()
                .map(Roles::getId)
                .collect(Collectors.toSet()));

        // Set department
        if (employee.getDepartment() != null) {
        	employeeDTO.setDepartmentId(employee.getDepartment().getId());

        }

        model.addAttribute("employeeDTO", employeeDTO);
        model.addAttribute("employeeId", id);
        model.addAttribute("roles", rolesRepository.findAll());
        model.addAttribute("departments", departmentRepository.findAll());

        return "edit-employee"; // Template: edit-employee.html
    }

    
    @PostMapping("/employees/edit/{id}")
    public String updateEmployee(@PathVariable Long id,
                                 @Valid @ModelAttribute("employeeDTO") EmployeeDTO employeeDTO,
                                 BindingResult result,
                                 Model model,
                                 RedirectAttributes attributes) {
        if (employeeDTO.getRoles() == null || employeeDTO.getRoles().isEmpty()) {
            result.addError(new FieldError("employeeDTO", "roles", "At least one role must be selected"));
        }

        if (result.hasErrors()) {
            model.addAttribute("employeeId", id);
            model.addAttribute("roles", rolesRepository.findAll());
            model.addAttribute("departments", departmentRepository.findAll());
            return "edit-employee";
        }

        // ✅ Call authService to update employee and handle tasks
        authService.updateEmployee(employeeDTO, id);

        attributes.addFlashAttribute("success", "Employee updated successfully!");
        return "redirect:/employees";
    }


    // ✅ Show login page
//    @GetMapping("/login")
//    public String showEmployeeLogin() {
//        return "employee-login";
//    }

    // ✅ Handle login
    @PostMapping("/login")
    public String handleEmployeeLogin(@RequestParam String email,
                                      @RequestParam String password,
                                      HttpSession session,
                                      Model model) {

        Optional<Employee> optionalEmployee = employeeRepository.findByEmail(email);

        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            if (employee.getPassword().equals(password)) {
                session.setAttribute("loggedInEmployee", employee);
                return "redirect:/employees/dashboard"; // 👈 Update the path if needed
            }
        }

        model.addAttribute("error", "Invalid email or password");
        return "employee-login"; // 👈 This should match your login.html filename
    }


    // ✅ Show dashboard
 // ✅ Use a unique URL like /employee/dashboard
    @GetMapping("/employee/dashboard")
    public String showEmployeeDashboard(HttpSession session, Model model) {
        Employee employee = (Employee) session.getAttribute("loggedInEmployee");
        if (employee == null) {
            return "redirect:/employees/login";
        }
        model.addAttribute("employee", employee);
        return "employee-dashboard";
    }
    @GetMapping("/employees/{id}/assign-task")
    public String showAssignTaskForm(@PathVariable Long id, Model model) {
        Employee employee = authService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        model.addAttribute("task", new TaskDTO());  // You can customize TaskDTO
        return "assign-task";
    }

    @PostMapping("/employees/{id}/assign-task")
    public String assignTask(@PathVariable Long id, @ModelAttribute("task") TaskDTO taskDTO) {
        authService.assignTaskToEmployee(id, taskDTO);
        return "redirect:/employees?success=taskAssigned";
    }



    // ✅ Logout
    @GetMapping("/logout")
    public String employeeLogout(HttpSession session) {
        session.invalidate();
        return "redirect:/employees/login";
    }
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setAddress(new EmployeeDTO.AddressDTO()); // 💡 Important for form binding!
        model.addAttribute("employeeDTO", dto);
        model.addAttribute("departments", departmentRepository.findAll());
        return "registration";
    }



    @PostMapping("/register")
    public String processRegister(@Valid @ModelAttribute("employee") EmployeeDTO dto,
                                  BindingResult result,
                                  Model model) {
        if (dto.getDepartmentId() == null) {
            result.rejectValue("departmentId", "NotNull", "Department is required.");
        }

        if (result.hasErrors()) {
            model.addAttribute("departments", departmentRepository.findAll());
            return "registration";
        }

        try {
            authService.registerUser(dto); // now includes tasks + returns Employee
            return "redirect:/login?registered=true";
        } catch (Exception e) {
            model.addAttribute("departments", departmentRepository.findAll());
            model.addAttribute("error", "Registration failed: " + e.getMessage());
            return "registration";
        }
    }





       
        @GetMapping("/login")
        public String showLoginPage(@RequestParam(value = "registered", required = false) String registered,
                                    Model model) {
            if (registered != null) {
                model.addAttribute("success", "Registration successful. Please login.");
            }
            return "employee-login";
        }
    
}

