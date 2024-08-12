package com.example.Healthcare.Services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Healthcare.Entity.PolicyHolder;
import com.example.Healthcare.Repository.PolicyHolderRepository;

@Service
public class PolicyHolderService implements CrudService<PolicyHolder, Integer>   {
	

	 @Autowired
	    private PolicyHolderRepository policyHolderRepository;

	    @Override
	    public PolicyHolder create(PolicyHolder policyHolder) {
	        return policyHolderRepository.save(policyHolder);
	    }

	    @Override
	    public List<PolicyHolder> fetchAll() {
	        return policyHolderRepository.findAll();
	    }

	    @Override
	    public PolicyHolder fetchById(Integer id) {
	        return policyHolderRepository.findById(id).orElse(null);
	    }

	    @Override
	    public PolicyHolder update(PolicyHolder existingPolicyHolder, PolicyHolder newPolicyHolder) {
	        existingPolicyHolder.setUser(newPolicyHolder.getUser());
	        existingPolicyHolder.setPolicy(newPolicyHolder.getPolicy());
	        existingPolicyHolder.setCoverageType(newPolicyHolder.getCoverageType());
	        existingPolicyHolder.setPolicyHolderId(newPolicyHolder.getPolicyHolderId());
	        existingPolicyHolder.setFullName(newPolicyHolder.getFullName());
	        existingPolicyHolder.setMobileNo(newPolicyHolder.getMobileNo());
	        existingPolicyHolder.setDateOfBirth(newPolicyHolder.getDateOfBirth());
	        existingPolicyHolder.setGender(newPolicyHolder.getGender());
	        return policyHolderRepository.save(existingPolicyHolder);
	    }

	    @Override
	    public String delete(PolicyHolder policyHolder) {
	        policyHolderRepository.delete(policyHolder);
	        return "PolicyHolder deleted successfully!";
	    }
}


