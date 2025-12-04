package com.example.smartevent.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.smartevent.models.Stall;
import com.example.smartevent.models.User;
import com.example.smartevent.models.VisitorPoints;

public interface VisitorPointsRepository extends JpaRepository<VisitorPoints, Long> {
	Optional<VisitorPoints> findByVisitorAndStall(User visitor, Stall stall);
    List<VisitorPoints> findByVisitor(User visitor);
    List<VisitorPoints> findByStall(Stall stall);


}
