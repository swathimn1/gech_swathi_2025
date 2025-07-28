package com.example.dbrelationship.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.dbrelationship.dto.EmployeeDTO;
import com.example.dbrelationship.dto.TaskDTO;
import com.example.dbrelationship.model.Address;
import com.example.dbrelationship.model.Department;
import com.example.dbrelationship.model.Employee;
import com.example.dbrelationship.model.Roles;
import com.example.dbrelationship.model.Task;
import com.example.dbrelationship.repository.DepartmentsRepository;
import com.example.dbrelationship.repository.EmployeeRepository;
import com.example.dbrelationship.repository.RolesRepository;
import com.example.dbrelationship.repository.TaskRepository;

@Service
public class AuthService {

	private final PasswordEncoder passwordEncoder;
	private final EmployeeRepository employeeRepository;
	private final RolesRepository rolesRepository;
	private final DepartmentsRepository departmentsRepository;
	private  final TaskRepository taskRepository;

	

	public AuthService(PasswordEncoder passwordEncoder, EmployeeRepository employeeRepository,
			RolesRepository rolesRepository, DepartmentsRepository departmentsRepository,
			TaskRepository taskRepository) {
		super();
		this.passwordEncoder = passwordEncoder;
		this.employeeRepository = employeeRepository;
		this.rolesRepository = rolesRepository;
		this.departmentsRepository = departmentsRepository;
		this.taskRepository = taskRepository;
	}

	public Employee saveEmployee(EmployeeDTO employeeDTO) {
		Department dept = departmentsRepository.findById(employeeDTO.getDepartmentId())
				.orElseThrow(() -> new RuntimeException("Department not found"));

		Employee employee = new Employee();
		employee.setName(employeeDTO.getName());
		employee.setEmail(employeeDTO.getEmail());
		employee.setPassword(passwordEncoder.encode(employeeDTO.getPassword()));
		employee.setDepartment(dept);

		Address address = new Address();
		address.setStreet(employeeDTO.getAddress().getStreet());
		address.setCity(employeeDTO.getAddress().getCity());
		address.setState(employeeDTO.getAddress().getState());
		address.setEmployee(employee);
		employee.setAddress(address);

		List<Roles> roles = rolesRepository.findAllById(employeeDTO.getRoles());
		employee.setRoles(new HashSet<>(roles));

		return employeeRepository.save(employee);
	}

	public Employee registerUser(EmployeeDTO dto) {
	    if (employeeRepository.findByEmail(dto.getEmail()).isPresent()) {
	        throw new RuntimeException("Email already registered");
	    }

	    Employee employee = new Employee();
	    employee.setName(dto.getName());
	    employee.setEmail(dto.getEmail());
	    employee.setPassword(passwordEncoder.encode(dto.getPassword()));

	    // Default role
	    Roles defaultRole = rolesRepository.findByName("USER")
	        .orElseThrow(() -> new RuntimeException("Default role USER not found"));
	    employee.setRoles(Set.of(defaultRole));

	    // Department
	    if (dto.getDepartmentId() != null) {
	        Department dept = departmentsRepository.findById(dto.getDepartmentId())
	            .orElseThrow(() -> new RuntimeException("Department not found"));
	        employee.setDepartment(dept);
	    }

	    // Address
	    Address address = new Address();
	    address.setStreet(dto.getAddress().getStreet());
	    address.setCity(dto.getAddress().getCity());
	    address.setState(dto.getAddress().getState());
	    address.setEmployee(employee);
	    employee.setAddress(address);

	    // Tasks
	    List<Task> tasks = new ArrayList<>();

	    // Existing taskIds
	    if (dto.getTaskIds() != null) {
	        for (Long taskId : dto.getTaskIds()) {
	            taskRepository.findById(taskId).ifPresent(tasks::add);
	        }
	    }

	    // New tasks
	    if (dto.getTaskTitles() != null && dto.getTaskDescriptions() != null) {
	        for (int i = 0; i < dto.getTaskTitles().size(); i++) {
	            String title = dto.getTaskTitles().get(i);
	            String desc = i < dto.getTaskDescriptions().size() ? dto.getTaskDescriptions().get(i) : "";
	            if (title != null && !title.trim().isEmpty()) {
	                Task task = new Task();
	                task.setTitle(title);
	                task.setDescription(desc);
	                task.setEmployee(employee);
	                tasks.add(task);
	            }
	        }
	    }

	    employee.setTasks(tasks);

	    return employeeRepository.save(employee); // ✅ Return saved employee
	}





	public void updateEmployee(EmployeeDTO employeeDTO, Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));

		employee.setName(employeeDTO.getName());
		employee.setEmail(employeeDTO.getEmail());
		employee.setPassword(passwordEncoder.encode(employeeDTO.getPassword()));

		Address address = employee.getAddress();
		if (address == null) {
			address = new Address();
			address.setEmployee(employee);
		}
		address.setStreet(employeeDTO.getAddress().getStreet());
		address.setCity(employeeDTO.getAddress().getCity());
		address.setState(employeeDTO.getAddress().getState());
		employee.setAddress(address);

		List<Roles> roles = rolesRepository.findAllById(employeeDTO.getRoles());
		employee.setRoles(new HashSet<>(roles));

		employee.getTasks().clear();

		List<String> titles = employeeDTO.getTaskTitles();
		List<String> descriptions = employeeDTO.getTaskDescriptions();

		if (titles != null && descriptions != null) {
			for (int i = 0; i < titles.size(); i++) {
				String title = titles.get(i);
				String desc = i < descriptions.size() ? descriptions.get(i) : "";

				if (title != null && !title.trim().isEmpty()) {
					Task task = new Task();
					task.setTitle(title);
					task.setDescription(desc);
					task.setEmployee(employee);
					employee.getTasks().add(task);
				}
			}
		}

		employeeRepository.save(employee);
	}

	public Employee findByEmail(String email) {
        return employeeRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Employee not found with email: " + email));
    }
	public void assignTaskToEmployee(Long employeeId, TaskDTO taskDTO) {
	    Employee employee = employeeRepository.findById(employeeId)
	                            .orElseThrow(() -> new RuntimeException("Employee not found"));
	    
	    Task task = new Task();
	    task.setTitle(taskDTO.getTitle());
	    task.setDescription(taskDTO.getDescription());
	    task.setEmployee(employee);

	    taskRepository.save(task);
	}
	public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
    }

}
