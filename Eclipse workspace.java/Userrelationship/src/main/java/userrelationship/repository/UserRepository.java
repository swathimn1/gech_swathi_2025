package userrelationship.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import userrelationship.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
