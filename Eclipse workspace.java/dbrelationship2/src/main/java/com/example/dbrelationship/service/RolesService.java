package com.example.dbrelationship.service;

import java.util.List;
import java.util.Optional;

import javax.management.relation.Role;

import org.springframework.stereotype.Service;

import com.example.dbrelationship.dto.RolesDTO;
import com.example.dbrelationship.model.Employee;
import com.example.dbrelationship.model.Roles;
import com.example.dbrelationship.repository.RolesRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RolesService {

	private final RolesRepository rolesRepository;

	public RolesService(RolesRepository rolesRepository) {
		this.rolesRepository = rolesRepository;
	}

	public void saveRole(RolesDTO roleDTO) {
		Roles role = new Roles();
		role.setName(roleDTO.getName().toUpperCase());
		rolesRepository.save(role);
	}

	public List<Roles> getAllRoles() {
		return rolesRepository.findAll();
	}

	public Optional<Roles> getRoleById(Long id) {
		return rolesRepository.findById(id);
	}

	public void deleteRole(Long id) {
		Roles roles = rolesRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Role not found"));
		for (Employee employee : roles.getEmployees()) {
			employee.getRoles().remove(roles);
		}
		rolesRepository.deleteById(id);
	}

	public void updateRole(RolesDTO roleDTO, Long id) {
		Roles existingRole = rolesRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Role not found with ID: " + id));

		existingRole.setName(roleDTO.getName().toUpperCase());

		rolesRepository.save(existingRole);
	}

}
