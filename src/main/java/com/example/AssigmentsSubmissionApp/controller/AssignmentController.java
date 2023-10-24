package com.example.AssigmentsSubmissionApp.controller;

import com.example.AssigmentsSubmissionApp.domain.Assigment;
import com.example.AssigmentsSubmissionApp.domain.User;
import com.example.AssigmentsSubmissionApp.service.AssignmetnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/assignments")
public class AssignmentController {
    @Autowired
    private AssignmetnService assignmetnService;

    @PostMapping("")
    public ResponseEntity<?> createAssignment(@AuthenticationPrincipal User user){
        Assigment newAssignment =  assignmetnService.save(user);

        return ResponseEntity.ok(newAssignment);
    }
}
