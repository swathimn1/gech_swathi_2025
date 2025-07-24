package com.example.dbrelationship.repository;

import java.util.Optional;

import javax.management.relation.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dbrelationship.model.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {
	Optional<Roles> findByName(String name);

}
