package com.example.Healthcare.Controller;

import java.util.List;

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

import com.example.Healthcare.Entity.PolicyHolder;
import com.example.Healthcare.Services.PolicyHolderService;
@RestController
@RequestMapping("/api/policyholders")
public class PolicyHolderController {

    @Autowired
    private PolicyHolderService policyHolderService;

    
    @GetMapping
    public ResponseEntity<List<PolicyHolder>> getAllPolicyHolders() {
        List<PolicyHolder> policyHolders = policyHolderService.fetchAll();
        return new ResponseEntity<>(policyHolders, HttpStatus.OK);
    }

  
    @GetMapping("/{id}")
    public ResponseEntity<PolicyHolder> getPolicyHolderById(@PathVariable Integer id) {
        PolicyHolder policyHolder = policyHolderService.fetchById(id);
        return policyHolder != null ? new ResponseEntity<>(policyHolder, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

  
    @PostMapping
    public ResponseEntity<PolicyHolder> createPolicyHolder(@RequestBody PolicyHolder policyHolder) {
        PolicyHolder createdPolicyHolder = policyHolderService.create(policyHolder);
        return new ResponseEntity<>(createdPolicyHolder, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<PolicyHolder> updatePolicyHolder(@PathVariable Integer id, @RequestBody PolicyHolder policyHolderDetails) {
        PolicyHolder existingPolicyHolder = policyHolderService.fetchById(id);
        if (existingPolicyHolder == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        PolicyHolder updatedPolicyHolder = policyHolderService.update(existingPolicyHolder, policyHolderDetails);
        return new ResponseEntity<>(updatedPolicyHolder, HttpStatus.OK);
    }

  
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePolicyHolder(@PathVariable Integer id) {
        PolicyHolder existingPolicyHolder = policyHolderService.fetchById(id);
        if (existingPolicyHolder == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        policyHolderService.delete(existingPolicyHolder);
        return new ResponseEntity<>("PolicyHolder deleted successfully!", HttpStatus.NO_CONTENT);
    }
}

