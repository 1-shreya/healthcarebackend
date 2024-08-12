package com.example.Healthcare.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Healthcare.Entity.CoverageType;
import com.example.Healthcare.Repository.CoverageTypeRepository;

@Service
public class CoverageTypeService implements CrudService<CoverageType, Integer> {
	@Autowired
    private CoverageTypeRepository coveragePlanRepository;

	@Override
	public CoverageType create(CoverageType coveragetype) {
		 return coveragePlanRepository.save(coveragetype);
	
	}

	@Override
	public List<CoverageType> fetchAll() {
		 return coveragePlanRepository.findAll();
		
	}
	
	@Override
	public CoverageType fetchById(Integer id) {
		  return coveragePlanRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("CoveragePlan not found with ID: " + id));
	}

	@Override
	public CoverageType update(CoverageType existingCoveragePlan, CoverageType updatedCoveragePlan) {
		existingCoveragePlan.setCoverage_id(updatedCoveragePlan.getCoverage_id());
        existingCoveragePlan.setAdult(updatedCoveragePlan.getAdult());
        existingCoveragePlan.setChildren(updatedCoveragePlan.getChildren());
        existingCoveragePlan.setType(updatedCoveragePlan.getType());
        return coveragePlanRepository.save(existingCoveragePlan);
	}

	@Override
	public String delete(CoverageType coveragetype) {
		coveragePlanRepository.delete(coveragetype);
        return "CoveragePlan deleted successfully";
	}

   

}
