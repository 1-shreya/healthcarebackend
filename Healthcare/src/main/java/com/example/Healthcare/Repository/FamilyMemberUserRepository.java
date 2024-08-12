package com.example.Healthcare.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Healthcare.Entity.FamilyMemberUser;

public interface FamilyMemberUserRepository extends JpaRepository<FamilyMemberUser, Integer> {

}
