package com.example.Healthcare.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Healthcare.Entity.Policy;
import com.example.Healthcare.Services.PolicyService;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    // Get all policies
    @GetMapping
    public ResponseEntity<List<Policy>> getAllPolicies() {
        List<Policy> policies = policyService.fetchAll();
        return new ResponseEntity<>(policies, HttpStatus.OK);
    }

    // Get policy by ID
    @GetMapping("/{id}")
    public ResponseEntity<Policy> getPolicyById(@PathVariable Integer id) {
        Policy policy = policyService.fetchById(id);
        return policy != null ? new ResponseEntity<>(policy, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Create a new policy
    @PostMapping
    public ResponseEntity<Policy> createPolicy(@RequestBody Policy policy) {
        Policy createdPolicy = policyService.create(policy);
        return new ResponseEntity<>(createdPolicy, HttpStatus.CREATED);
    }

    // Update an existing policy
    @PutMapping("/{id}")
    public ResponseEntity<Policy> updatePolicy(@PathVariable Integer id, @RequestBody Policy policyDetails) {
        Policy existingPolicy = policyService.fetchById(id);
        if (existingPolicy == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Policy updatedPolicy = policyService.update(existingPolicy, policyDetails);
        return new ResponseEntity<>(updatedPolicy, HttpStatus.OK);
    }

    // Delete a policy
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePolicy(@PathVariable Integer id) {
        Policy existingPolicy = policyService.fetchById(id);
        if (existingPolicy == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        policyService.delete(existingPolicy);
        return new ResponseEntity<>("Policy deleted successfully!", HttpStatus.NO_CONTENT);
    }
}