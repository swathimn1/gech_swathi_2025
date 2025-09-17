package studentcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import studentcrud.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	public Student findByEmail(String email);

}
