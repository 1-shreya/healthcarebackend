package com.example.Healthcare.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Healthcare.Entity.PolicyHolder;

public interface PolicyHolderRepository extends JpaRepository<PolicyHolder, Integer> {
 
}
