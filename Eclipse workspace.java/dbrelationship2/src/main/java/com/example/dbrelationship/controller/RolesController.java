package com.example.dbrelationship.controller;

import com.example.dbrelationship.dto.RolesDTO;
import com.example.dbrelationship.model.Roles;
import com.example.dbrelationship.repository.RolesRepository;
import com.example.dbrelationship.service.RolesService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/roles")
public class RolesController {

    private final RolesRepository rolesRepository;
    private final RolesService roleService;

    public RolesController(RolesRepository rolesRepository, RolesService roleService) {
        this.rolesRepository = rolesRepository;
        this.roleService = roleService;
    }

    // ✅ Display all roles
    @GetMapping({"", "/"})
    public String roles(Model model) {
        List<Roles> roles = rolesRepository.findAll();
        model.addAttribute("roles", roles);
        return "roles"; // templates/roles.html
    }

    // ✅ Show form to add a new role
    @GetMapping("/add")
    public String addRoleForm(Model model) {
        model.addAttribute("roleDTO", new RolesDTO());
        return "add-role"; // templates/add-role.html
    }

    
 // ✅ Save new role
    @PostMapping("/add")
    public String saveRole(@Validated @ModelAttribute("roleDTO") RolesDTO roleDTO,
                           BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("roleDTO", roleDTO);
            return "add-role"; // fix the return page name if needed
        }

        roleService.saveRole(roleDTO);
        return "redirect:/roles";
    }



    // ✅ Show edit form
    @GetMapping("/edit/{id}")
    public String editRoleForm(@PathVariable Long id, Model model, RedirectAttributes attributes) {
        Optional<Roles> roleOpt = rolesRepository.findById(id);
        if (roleOpt.isEmpty()) {
            attributes.addFlashAttribute("error", "Role not found.");
            return "redirect:/roles";
        }

        RolesDTO roleDTO = new RolesDTO();
        roleDTO.setName(roleOpt.get().getName());

        model.addAttribute("role", roleOpt.get());
        model.addAttribute("roleDTO", roleDTO);
        return "edit-role"; // templates/edit-role.html
    }

    // ✅ Update role
    @PostMapping("/edit/{id}")
    public String editRole(@Valid @ModelAttribute("roleDTO") RolesDTO roleDTO,
                           @PathVariable Long id,
                           BindingResult result,
                           RedirectAttributes attributes,
                           Model model) {

        Optional<Roles> existingRole = rolesRepository.findByName(roleDTO.getName().toUpperCase());
        if (existingRole.isPresent()) {
            Roles foundRole = existingRole.get();
            if (!foundRole.getId().equals(id)) {
                result.addError(new FieldError("roleDTO", "name", "Role with given name already exists."));
            }
        }

        if (result.hasErrors()) {
            rolesRepository.findById(id).ifPresent(role -> model.addAttribute("role", role));
            return "edit-role";
        }

        try {
            roleService.updateRole(roleDTO, id);
        } catch (EntityNotFoundException ex) {
            attributes.addFlashAttribute("error", ex.getMessage());
            return "redirect:/roles";
        }

        attributes.addFlashAttribute("success", "Role updated successfully.");
        return "redirect:/roles";
    }

    // ✅ Delete role
    @GetMapping("/delete/{id}")
    public String deleteRole(@PathVariable Long id, RedirectAttributes attributes) {
        Optional<Roles> roleOpt = rolesRepository.findById(id);
        if (roleOpt.isPresent()) {
            try {
                roleService.deleteRole(id);
            } catch (EntityNotFoundException ex) {
                attributes.addFlashAttribute("error", ex.getMessage());
                return "redirect:/roles";
            }
        } else {
            attributes.addFlashAttribute("error", "Role not found.");
            return "redirect:/roles";
        }

        attributes.addFlashAttribute("success", "Role deleted successfully.");
        return "redirect:/roles";
    }
}
