package com.example.AssigmentsSubmissionApp.repository;

import com.example.AssigmentsSubmissionApp.domain.Assigment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assigment,Long> {
}
