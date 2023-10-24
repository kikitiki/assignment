package com.example.AssigmentsSubmissionApp.service;

import com.example.AssigmentsSubmissionApp.domain.Assigment;
import com.example.AssigmentsSubmissionApp.domain.User;
import com.example.AssigmentsSubmissionApp.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignmetnService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    public Assigment save(User user) {
        Assigment assigment = new Assigment();
        assigment.setStatus("Needs to be submitted");
        assigment.setUser(user);

        return assignmentRepository.save(assigment);
    }
}
