package employeerelationship.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import employeerelationship.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
