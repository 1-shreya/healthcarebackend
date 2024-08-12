package com.example.Healthcare.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Healthcare.Entity.FamilyMember;
import com.example.Healthcare.Services.FamilyMemberService;
@RestController
@RequestMapping("/api/familymembers")
public class FamilyMemberController {
	 @Autowired
	    private FamilyMemberService memberService;

	 @GetMapping
	    public List<FamilyMember> getAllMembers() {
	        return memberService.fetchAll();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<FamilyMember> getMemberById(@PathVariable int id) {
	    	FamilyMember member = memberService.fetchById(id);
	        return ResponseEntity.ok(member);
	    }

	    @PostMapping
	    public FamilyMember createMember(@RequestBody FamilyMember member) {
	        return memberService.create(member);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<FamilyMember> updateMember(@PathVariable int id, @RequestBody FamilyMember member) {
	    	FamilyMember existingMember = memberService.fetchById(id);
	    	FamilyMember updatedMember = memberService.update(existingMember, member);
	        return ResponseEntity.ok(updatedMember);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteMember(@PathVariable int id) {
	    	FamilyMember member = memberService.fetchById(id);
	        memberService.delete(member);
	        return ResponseEntity.noContent().build();
	    }

}
