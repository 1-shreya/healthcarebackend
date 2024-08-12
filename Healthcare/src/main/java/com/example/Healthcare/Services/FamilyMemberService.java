package com.example.Healthcare.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Healthcare.Entity.FamilyMember;
import com.example.Healthcare.Repository.FamilyMemberRepository;
@Service
public class FamilyMemberService implements CrudService<FamilyMember,Integer> {
	 @Autowired
	    private FamilyMemberRepository memberRepository;

	@Override
	public FamilyMember create(FamilyMember familymember) {
		 return memberRepository.save(familymember);
		
	}

	@Override
	public List<FamilyMember> fetchAll() {
		  return memberRepository.findAll();
		
	}

	@Override
	public FamilyMember fetchById(Integer id) {
		 return memberRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Member not found with ID: " + id));
	}
		

	@Override
	public FamilyMember update(FamilyMember updatedMember , FamilyMember existingMember) {
		 existingMember.setFullname(updatedMember.getFullname());
	        existingMember.setDate_of_birth(updatedMember.getDate_of_birth());
	        existingMember.setGender(updatedMember.getGender());
	        existingMember.setMobile_number(updatedMember.getMobile_number());
	        existingMember.setRelationship(updatedMember.getRelationship());
	        existingMember.setOccupation(updatedMember.getOccupation());
	        return memberRepository.save(existingMember);
	}

	@Override
	public String delete(FamilyMember familymember) {
		 memberRepository.delete(familymember);
	        return "Member deleted successfully";
		
	}

	
	   
}
