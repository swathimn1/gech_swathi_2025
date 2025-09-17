package com.springbootmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootmvc.models.User;

@Repository
public interface Userrepository extends JpaRepository<User, Long> {

}
