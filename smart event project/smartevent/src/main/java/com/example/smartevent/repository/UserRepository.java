package com.example.smartevent.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.smartevent.models.Role;
import com.example.smartevent.models.Stall;
import com.example.smartevent.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);

	Optional<User> findByUsername(String username);

	

	int countByRole(Role role);
	boolean existsByEmail(String email);
    boolean existsByUsername(String username);

	List<User> findByRole(String string);

	Optional<Stall> findById(User visitorId);
}
