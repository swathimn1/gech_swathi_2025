package com.example.dbrelationship.controller;

import com.example.dbrelationship.dto.TaskDTO;
import com.example.dbrelationship.model.Employee;
import com.example.dbrelationship.model.Task;
import com.example.dbrelationship.repository.EmployeeRepository;
import com.example.dbrelationship.repository.TaskRepository;
import com.example.dbrelationship.service.TaskService;

import jakarta.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskRepository taskRepository;
    private final EmployeeRepository employeeRepository;
    private final TaskService taskService;

    public TaskController(TaskRepository taskRepository,
                          EmployeeRepository employeeRepository,
                          TaskService taskService) {
        this.taskRepository = taskRepository;
        this.employeeRepository = employeeRepository;
        this.taskService = taskService;
    }

   
    @GetMapping({ "", "/" })
    public String tasks(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        var authorities = userDetails.getAuthorities();
        if (authorities.stream().anyMatch(role -> role.getAuthority().equals("ROLE_ADMIN"))) {
            List<Task> tasks = taskRepository.findAll();
            model.addAttribute("tasks", tasks);
        } else {
            Employee employee = employeeRepository.findByEmail(userDetails.getUsername())
                    .orElseThrow(() -> new UsernameNotFoundException("Employee not found"));
            List<Task> tasks = taskRepository.findByEmployee(employee);
            model.addAttribute("tasks", tasks);
        }
        return "task-list";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/add-task")
    public String addTask(@RequestParam(required = false) Long employeeId,
                          Model model,
                          @AuthenticationPrincipal UserDetails userDetails) {
        TaskDTO taskDTO = new TaskDTO();

        if (employeeId != null) {
            taskDTO.setEmployeeId(employeeId); // Admin assigning task
        } else {
            Employee employee = employeeRepository.findByEmail(userDetails.getUsername())
                    .orElseThrow(() -> new UsernameNotFoundException("Employee not found"));
            taskDTO.setEmployeeId(employee.getId());
        }

        model.addAttribute("taskDTO", taskDTO);
        return "add-task";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add-task")
    public String saveTask(@Valid @ModelAttribute TaskDTO taskDTO,
                           BindingResult result,
                           Model model,
                           RedirectAttributes attributes) {

        if (result.hasErrors()) {
            return "add-task";
        }

        Employee employee = employeeRepository.findById(taskDTO.getEmployeeId())
                .orElseThrow(() -> new UsernameNotFoundException("Employee not found"));

        taskService.saveTask(taskDTO, employee);
        attributes.addFlashAttribute("success", "Task saved successfully!");

        return "redirect:/tasks";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/edit-task/{id}")
    public String editTask(@PathVariable Long id,
                           RedirectAttributes attributes,
                           Model model) {

        Optional<Task> task = taskRepository.findById(id);
        if (task.isEmpty()) {
            attributes.addFlashAttribute("error", "Task not found");
            return "redirect:/tasks";
        }

        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle(task.get().getTitle());
        taskDTO.setDescription(task.get().getDescription());
        taskDTO.setEmployeeId(task.get().getEmployee().getId());

        model.addAttribute("task", task.get());
        model.addAttribute("taskDTO", taskDTO);
        return "edit-task";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/edit-task/{id}")
    public String updateTask(@Valid @ModelAttribute TaskDTO taskDTO,
                             BindingResult result,
                             @PathVariable Long id,
                             Model model,
                             RedirectAttributes attributes) {

        if (result.hasErrors()) {
            Optional<Task> task = taskRepository.findById(id);
            model.addAttribute("task", task.orElse(null));
            return "edit-task";
        }

        Optional<Task> task = taskRepository.findById(id);
        if (task.isEmpty()) {
            attributes.addFlashAttribute("error", "Task not found");
            return "redirect:/tasks";
        }

        taskService.updateTask(taskDTO, id);
        attributes.addFlashAttribute("success", "Task updated successfully");
        return "redirect:/tasks";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/delete-task/{id}")
    public String deleteTask(@PathVariable Long id,
                             @AuthenticationPrincipal UserDetails userDetails,
                             RedirectAttributes redirectAttributes) {

        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Task not found");
            return "redirect:/tasks";
        }

        Task task = optionalTask.get();

        Employee employee = employeeRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        boolean isAdmin = userDetails.getAuthorities().stream()
                .anyMatch(role -> role.getAuthority().equals("ROLE_ADMIN"));

        if (!isAdmin && !task.getEmployee().getId().equals(employee.getId())) {
            redirectAttributes.addFlashAttribute("error", "You are not authorized to delete this task.");
            return "redirect:/tasks";
        }

        taskRepository.delete(task);
        redirectAttributes.addFlashAttribute("success", "Task deleted successfully");
        return "redirect:/tasks";
    }

}
