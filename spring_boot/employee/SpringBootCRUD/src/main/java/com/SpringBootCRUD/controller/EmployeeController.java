package com.SpringBootCRUD.controller;

import com.SpringBootCRUD.dto.Employeedto;
import com.SpringBootCRUD.models.Employee;
import com.SpringBootCRUD.services.EmployeeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")  
public class EmployeeController {
    private final EmployeeServices employeeServices;

    public EmployeeController(EmployeeServices employeeServices) {
        this.employeeServices = employeeServices;
    }

    @GetMapping({"", "/"})  
    public String getAllEmployees(Model model) {
        List<Employee> employees = employeeServices.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employee";  
    }

    @GetMapping("/add-employee")
    public String addEmployee(Model model) {
        model.addAttribute("employeedto", new Employeedto());
        return "add_employee";  
    }

    @PostMapping("/save-employee")
    public String saveEmployee(@ModelAttribute Employeedto employeedto) {
        employeeServices.saveEmployee(employeedto);
        return "redirect:/employees"; 
    }

    @GetMapping("/edit-employee")
    public String getEmployee(@RequestParam Long id, Model model) {
        Employee employee = employeeServices.getEmployee(id);
        if (employee == null) return "redirect:/employees";

        Employeedto employeedto = new Employeedto();
        employeedto.setFirstName(employee.getFirstName());
        employeedto.setLastName(employee.getLastName());
        employeedto.setEmail(employee.getEmail());
        employeedto.setPhone(employee.getPhone());
        employeedto.setDepartment(employee.getDepartment());

        model.addAttribute("employeedto", employeedto);
        model.addAttribute("employee", employee);
        return "edit_employee";  
    }

    @PostMapping("/edit-employee")
    public String updateEmployee(@ModelAttribute Employeedto employeedto, @RequestParam Long id) {
        employeeServices.updateEmployee(employeedto, id);
        return "redirect:/employees";  
    }

    @GetMapping("/delete-employee")
    public String deleteEmployee(@RequestParam Long id) {
        employeeServices.deleteEmployee(id);
        return "redirect:/employees";  
    }
}
