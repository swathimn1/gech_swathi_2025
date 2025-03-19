package com.SpringBootCRUD.services;

import com.SpringBootCRUD.dto.Employeedto;
import com.SpringBootCRUD.models.Employee;
import com.SpringBootCRUD.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServices {
    private final EmployeeRepository employeeRepository;

    public EmployeeServices(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void saveEmployee(Employeedto employeedto) {
        Employee employee = new Employee();
        employee.setFirstName(employeedto.getFirstName());
        employee.setLastName(employeedto.getLastName());
        employee.setEmail(employeedto.getEmail());
        employee.setPhone(employeedto.getPhone());
        employee.setDepartment(employeedto.getDepartment());
        employeeRepository.save(employee);
    }

    public Employee getEmployee(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public void updateEmployee(Employeedto employeedto, Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {
            employee.setFirstName(employeedto.getFirstName());
            employee.setLastName(employeedto.getLastName());
            employee.setEmail(employeedto.getEmail());
            employee.setPhone(employeedto.getPhone());
            employee.setDepartment(employeedto.getDepartment());
            employeeRepository.save(employee);
        }
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
