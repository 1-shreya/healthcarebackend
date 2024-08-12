package com.example.Healthcare.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Healthcare.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
