package com.example.dbrelationship.controller;

import com.example.dbrelationship.dto.DepartmentDTO;
import com.example.dbrelationship.model.Department;
import com.example.dbrelationship.repository.DepartmentsRepository;
import com.example.dbrelationship.service.DepartmentService;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentsRepository departmentRepository;
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentsRepository departmentRepository, DepartmentService departmentService) {
        this.departmentRepository = departmentRepository;
        this.departmentService = departmentService;
    }

    // ✅ List all departments
    @GetMapping
    public String listDepartments(Model model) {
        List<Department> departments = departmentRepository.findAll();
        model.addAttribute("departments", departments);
        return "departments"; // → View: departments.html
    }

    // ✅ Show add form
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("departmentDTO", new DepartmentDTO());
        return "add-department";
    }

    // ✅ Save department
    @PostMapping("/add")
    public String addDepartment(@Valid @ModelAttribute DepartmentDTO departmentDTO,
                                BindingResult result,
                                RedirectAttributes attributes) {
        Optional<Department> existing = departmentRepository.findByName(departmentDTO.getName());
        if (existing.isPresent()) {
            result.addError(new FieldError("departmentDTO", "name", "Department name already exists."));
        }

        if (result.hasErrors()) {
            return "add-department";
        }

        departmentService.saveDepartment(departmentDTO);
        attributes.addFlashAttribute("success", "Department saved successfully.");
        return "redirect:/departments";
    }

    // ✅ Show edit form
    @GetMapping("/edit/{id}")
    public String editDepartment(@PathVariable Long id, Model model, RedirectAttributes attributes) {
        Optional<Department> deptOpt = departmentRepository.findById(id);
        if (deptOpt.isEmpty()) {
            attributes.addFlashAttribute("error", "Department not found.");
            return "redirect:/departments";
        }

        Department department = deptOpt.get();
        DepartmentDTO dto = new DepartmentDTO();
        dto.setName(department.getName());

        model.addAttribute("department", department);
        model.addAttribute("departmentDTO", dto);
        return "edit-department";
    }

    // ✅ Update department
    @PostMapping("/edit/{id}")
    public String updateDepartment(@PathVariable Long id,
                                   @Valid @ModelAttribute DepartmentDTO departmentDTO,
                                   BindingResult result,
                                   Model model,
                                   RedirectAttributes attributes) {
        Optional<Department> existing = departmentRepository.findByName(departmentDTO.getName());
        if (existing.isPresent() && !existing.get().getId().equals(id)) {
            result.addError(new FieldError("departmentDTO", "name", "Department name already exists."));
        }

        if (result.hasErrors()) {
            departmentRepository.findById(id)
                    .ifPresent(dept -> model.addAttribute("department", dept));
            return "edit-department";
        }

        departmentService.updateDepartment(departmentDTO, id);
        attributes.addFlashAttribute("success", "Department updated successfully.");
        return "redirect:/departments";
    }

    // ✅ Delete department
    @GetMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable Long id, RedirectAttributes attributes) {
        try {
            departmentService.deleteDepartment(id);
            attributes.addFlashAttribute("success", "Department deleted successfully.");
        } catch (Exception e) {
            attributes.addFlashAttribute("error", "Unable to delete department.");
        }
        return "redirect:/departments";
    }
}
