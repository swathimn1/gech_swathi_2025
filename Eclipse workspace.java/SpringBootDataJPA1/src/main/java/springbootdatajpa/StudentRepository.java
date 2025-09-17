package springbootdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	Student findByEmail(String email);

	void deleteAllById(List<Long> of);

}
