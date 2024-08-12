package com.example.Healthcare.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Healthcare.Entity.FamilyMember;

public interface FamilyMemberRepository extends JpaRepository<FamilyMember, Integer> {

	

}
