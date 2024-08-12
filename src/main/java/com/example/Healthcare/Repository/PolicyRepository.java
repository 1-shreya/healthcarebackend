package com.example.Healthcare.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Healthcare.Entity.Policy;

public interface PolicyRepository extends JpaRepository<Policy,Integer> {

}
