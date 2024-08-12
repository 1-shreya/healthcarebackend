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

import com.example.Healthcare.Entity.CoverageType;
import com.example.Healthcare.Services.CoverageTypeService;

@RestController
@RequestMapping("/api/coveragetypes")
public class CoverageTypeController {
	   @Autowired
	    private CoverageTypeService coveragetypeservice;

	    @GetMapping
	    public List<CoverageType> getAllCoveragePlans() {
	        return coveragetypeservice.fetchAll();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<CoverageType> getCoveragePlanById(@PathVariable int id) {
	    	CoverageType coveragePlan = coveragetypeservice.fetchById(id);
	        return ResponseEntity.ok(coveragePlan);
	    }

	    @PostMapping
	    public CoverageType createCoveragePlan(@RequestBody CoverageType coveragePlan) {
	        return coveragetypeservice.create(coveragePlan);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<CoverageType> updateCoveragePlan(@PathVariable int id, @RequestBody CoverageType coveragePlan) {
	    	CoverageType existingCoveragePlan = coveragetypeservice.fetchById(id);
	    	CoverageType updatedCoveragePlan = coveragetypeservice.update(existingCoveragePlan, coveragePlan);
	        return ResponseEntity.ok(updatedCoveragePlan);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteCoveragePlan(@PathVariable int id) {
	    	CoverageType coveragePlan = coveragetypeservice.fetchById(id);
	        coveragetypeservice.delete(coveragePlan);
	        return ResponseEntity.noContent().build();
	    }
}

