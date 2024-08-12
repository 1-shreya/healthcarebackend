package com.example.Healthcare.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Healthcare.Entity.CoverageType;

public interface CoverageTypeRepository extends JpaRepository<CoverageType, Integer> {

}
