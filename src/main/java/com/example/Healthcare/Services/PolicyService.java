package com.example.Healthcare.Services;



import com.example.Healthcare.Entity.Policy;
import com.example.Healthcare.Repository.PolicyRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyService implements CrudService<Policy, Integer> {

    @Autowired
    private PolicyRepository policyRepository;

    @Override
    public Policy create(Policy policy) {
        return policyRepository.save(policy);
    }

    @Override
    public List<Policy> fetchAll() {
        return policyRepository.findAll();
    }

    @Override
    public Policy fetchById(Integer policyId) {
        return policyRepository.findById(policyId).orElse(null);
    }

    @Override
    public Policy update(Policy existingPolicy, Policy newPolicy) {
        existingPolicy.setPolicyName(newPolicy.getPolicyName());
        existingPolicy.setPolicyNo(newPolicy.getPolicyNo());
        existingPolicy.setPolicyPeriod(newPolicy.getPolicyPeriod());
        existingPolicy.setSumInsured(newPolicy.getSumInsured());
        existingPolicy.setDescription(newPolicy.getDescription());
        existingPolicy.setKeyFeatures(newPolicy.getKeyFeatures());
        existingPolicy.setPremium(newPolicy.getPremium());
        return policyRepository.save(existingPolicy);
    }

    @Override
    public String delete(Policy policy) {
        policyRepository.delete(policy);
        return "Policy deleted successfully!";
    }
}