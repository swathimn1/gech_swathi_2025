package studentcrud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import studentcrud.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	 Optional<Student> findByEmail(String email);

}
