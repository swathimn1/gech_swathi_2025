package com.example.studentform.validation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentform.validation.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	
   /*spring data jpa->jpa->hibernate->jdbc(java database connection->database
    * 
    *  1.to get all details->findAll()
    *  2.to get single data-> findById()
    *  3.to delete data->deleteById()
    *  4.to save student-save()
    *  */
	/* difference between crud(only crud operation)and  jpa repository(crud&pagination and sorting)- */
	
/*
 * findById->an object like Student
 * existsBy->Boolean
 * */
	public Student findByEmail(String email);
}
