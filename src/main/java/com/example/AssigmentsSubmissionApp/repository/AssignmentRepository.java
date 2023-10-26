package com.example.AssigmentsSubmissionApp.repository;

import com.example.AssigmentsSubmissionApp.domain.Assigment;
import com.example.AssigmentsSubmissionApp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface AssignmentRepository extends JpaRepository<Assigment,Long> {
    Set<Assigment> findByUser(User user);
}
