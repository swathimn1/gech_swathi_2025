package com.geccrud.SpringBootCRUD.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.geccrud.SpringBootCRUD.dto.EmployeeDTO;
import com.geccrud.SpringBootCRUD.models.Employee;
import com.geccrud.SpringBootCRUD.service.EmployeeService;



@Controller
public class EmployeeController {
	
	private final EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@GetMapping({"","/"})
	public String getAllEmployees(Model model) {
		List<Employee> employees =  employeeService.getAllEmployees();
		model.addAttribute("employees",employees);
		return "students";
	}
	
	@GetMapping("/add-student")
	public String addStudent(Model model) {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		model.addAttribute("employeeDTO",employeeDTO);
		return "add_employee";
	}
	@PostMapping("/add-employee")
	public String saveEmployee(@ModelAttribute EmployeeDTO employeeDTO) {
		employeeService.saveEmployee(employeeDTO);
		return "redirect:/";
	}
	
	@GetMapping("/edit-student")
	public String getMethodName(@RequestParam Long id,Model model) {
		Employee employee=employeeService.getEmployee(id);
		EmployeeDTO employeeDTO=new EmployeeDTO();
		
		    employeeDTO.setFirstName(employee.getFirstName());
		    employeeDTO.setLastName(employee.getLastName());
		    employeeDTO.setEmail(employee.getEmail());
		    employeeDTO.setPhone(employee.getPhone());
		    employeeDTO.setDepartment(employee.getDepartment());

		model.addAttribute("employeeDTO",employeeDTO);
		model.addAttribute("employee",employee);
		return "edit-employee";
	}
	@PostMapping("/edit-employee")
	public String updateEmployee(@ModelAttribute EmployeeDTO studentDTO,@RequestParam Long id) {
		employeeService.updateEmployee(studentDTO,id);  // Now StudentDTO should contain ID
	    return "redirect:/";
	}
	@GetMapping("/delete-employee")
	public String deleteEmployee(@RequestParam Long id) {
		employeeService.deleteEmployee(id);
		return "redirect:/";
	}
}
	

	
	
