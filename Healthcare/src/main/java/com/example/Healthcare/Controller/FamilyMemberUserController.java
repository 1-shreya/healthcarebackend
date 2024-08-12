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

import com.example.Healthcare.Entity.FamilyMemberUser;
import com.example.Healthcare.Services.FamilyMemberUserService;

@RestController
@RequestMapping("/api/familyusermembers")
public class FamilyMemberUserController {
	@Autowired
    private FamilyMemberUserService familyMemberUserService; 

	 @GetMapping
	    public List<FamilyMemberUser> getAllUsers() {
	        return familyMemberUserService.fetchAll();
	    }

	  @GetMapping("/{id}")
	    public ResponseEntity<FamilyMemberUser> getUserById(@PathVariable int id) {
		  FamilyMemberUser user = familyMemberUserService.fetchById(id);
	        return ResponseEntity.ok(user);
	    }

	    @PostMapping
	    public FamilyMemberUser createUser(@RequestBody FamilyMemberUser user) {
	        return familyMemberUserService.create(user);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<FamilyMemberUser> updateUser(@PathVariable int id, @RequestBody FamilyMemberUser user) {
	    	FamilyMemberUser existingUser = familyMemberUserService.fetchById(id);
	    	FamilyMemberUser updatedUser = familyMemberUserService.update(existingUser, user);
	        return ResponseEntity.ok(updatedUser);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
	    	FamilyMemberUser user = familyMemberUserService.fetchById(id);
	    	familyMemberUserService.delete(user);
	        return ResponseEntity.noContent().build();
	    }
	

}
