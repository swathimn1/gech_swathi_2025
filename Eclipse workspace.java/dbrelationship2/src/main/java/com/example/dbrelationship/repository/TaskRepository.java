package com.example.dbrelationship.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dbrelationship.model.Employee;
import com.example.dbrelationship.model.Task;
@Repository
public interface TaskRepository extends JpaRepository<Task,Long>{
	List<Task> findByEmployee(Employee employee);
}
