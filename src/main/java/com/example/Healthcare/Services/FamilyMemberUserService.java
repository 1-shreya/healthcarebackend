package com.example.Healthcare.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Healthcare.Entity.FamilyMemberUser;
import com.example.Healthcare.Repository.FamilyMemberUserRepository;

@Service
public class FamilyMemberUserService implements CrudService<FamilyMemberUser, Integer> {
	@Autowired
    private FamilyMemberUserRepository familymemberuserrepository;

	@Override
	public FamilyMemberUser create(FamilyMemberUser familymemberuser) {
		 return familymemberuserrepository.save(familymemberuser);
	}

	@Override
	public List<FamilyMemberUser> fetchAll() {
		 return familymemberuserrepository.findAll();
	}

	@Override
	public FamilyMemberUser fetchById(Integer id) {
		return familymemberuserrepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
	}

	@Override
	public FamilyMemberUser update(FamilyMemberUser existingUser, FamilyMemberUser updatedUser) {
		existingUser.setFamilymemberid(updatedUser.getFamilymemberid());
        return familymemberuserrepository.save(existingUser);
	}

	@Override
	public String delete(FamilyMemberUser familymemberuser) {
		 familymemberuserrepository.delete(familymemberuser);
	        return "User deleted successfully";
	}



 
}
