package userrelationship.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import userrelationship.models.UserDetails;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {

}
