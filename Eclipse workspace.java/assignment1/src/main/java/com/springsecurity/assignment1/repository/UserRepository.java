package com.springsecurity.assignment1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springsecurity.assignment1.model.User;
@Repository
public interface UserRepository  extends JpaRepository<User,Long>{
  User findByUsername(String username);
}
