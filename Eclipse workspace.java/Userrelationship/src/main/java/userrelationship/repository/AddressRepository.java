package userrelationship.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import userrelationship.models.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
