package com.geccrud.SpringBootCRUD.controller;

import com.geccrud.SpringBootCRUD.dto.EmployeeDTO;
import com.geccrud.SpringBootCRUD.models.Employee;
import com.geccrud.SpringBootCRUD.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping({"/employees"})
    public String getAllEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employees"; 
    }

    @GetMapping("/add-employee")
    public String addEmployee(Model model) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        model.addAttribute("employeeDTO", employeeDTO);
        return "add_employee"; 
    }

    @PostMapping("/add-employee")
    public String saveEmployee(@ModelAttribute EmployeeDTO employeeDTO) {
        employeeService.saveEmployee(employeeDTO);
        return "redirect:/employees";
    }

    @GetMapping("/edit-employee")
    public String editEmployee(@RequestParam Long id, Model model) {
        Employee employee = employeeService.getEmployee(id);
        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setFirstName(employee.getFirstName());
        employeeDTO.setLastName(employee.getLastName());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setPhone(employee.getPhone());
        
        model.addAttribute("employeeDTO", employeeDTO);
        model.addAttribute("employee", employee);
        return "edit_employee"; 
    }

    @PostMapping("/edit-employee")
    public String updateEmployee(@ModelAttribute EmployeeDTO employeeDTO, @RequestParam Long id) {
        employeeService.updateEmployee(employeeDTO, id);
        return "redirect:/employees";
    }

    @GetMapping("/delete-employee")
    public String deleteEmployee(@RequestParam Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
}


