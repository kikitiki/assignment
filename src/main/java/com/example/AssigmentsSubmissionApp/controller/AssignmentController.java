package com.example.AssigmentsSubmissionApp.controller;

import com.example.AssigmentsSubmissionApp.domain.Assigment;
import com.example.AssigmentsSubmissionApp.domain.User;
import com.example.AssigmentsSubmissionApp.service.AssignmetnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

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

    @GetMapping("")
    public ResponseEntity<?> getAssignments(@AuthenticationPrincipal User user){
        return  ResponseEntity.ok(assignmetnService.findByUser(user));
    }

    @GetMapping("{assignmentId}")
    public ResponseEntity<?> getAssignments(@PathVariable Long assignmentId ,@AuthenticationPrincipal User user){
      Optional<Assigment> assigmentOpt =  assignmetnService.findById(assignmentId);
        return  ResponseEntity.ok(assigmentOpt.orElse(new Assigment()));
    }

    @PutMapping("{assignmentId}")
    public ResponseEntity<?> updateAssignments(@PathVariable Long assignmentId,
                                               @RequestBody Assigment assigment,
                                               @AuthenticationPrincipal User user){
        Assigment updateAssignment = assignmetnService.save(assigment);
        return  ResponseEntity.ok(updateAssignment);
    }
}
