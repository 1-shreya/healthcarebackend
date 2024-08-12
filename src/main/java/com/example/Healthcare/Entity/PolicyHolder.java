package com.example.Healthcare.Entity;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "policy_holders")
public class PolicyHolder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int individualPolicyId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Foreign key referencing User table

    @ManyToOne
    @JoinColumn(name = "policy_id", nullable = false)
    private Policy policy; // Foreign key referencing Policy table

    @ManyToOne
    @JoinColumn(name = "coverage_type_id", nullable = false)
    private CoverageType coverageType; // Foreign key referencing Coverage Type table

    private Integer policyHolderId; 
    private String fullName; 
    private String mobileNo; 
    private String dateOfBirth; 
    private String gender; 
    public PolicyHolder() {
		// TODO Auto-generated constructor stub
	}
	public PolicyHolder(int individualPolicyId, User user, Policy policy, CoverageType coverageType,
			Integer policyHolderId, String fullName, String mobileNo, String dateOfBirth, String gender) {
		super();
		this.individualPolicyId = individualPolicyId;
		this.user = user;
		this.policy = policy;
		this.coverageType = coverageType;
		this.policyHolderId = policyHolderId;
		this.fullName = fullName;
		this.mobileNo = mobileNo;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}
	public int getIndividualPolicyId() {
		return individualPolicyId;
	}
	public void setIndividualPolicyId(int individualPolicyId) {
		this.individualPolicyId = individualPolicyId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Policy getPolicy() {
		return policy;
	}
	public void setPolicy(Policy policy) {
		this.policy = policy;
	}
	public CoverageType getCoverageType() {
		return coverageType;
	}
	public void setCoverageType(CoverageType coverageType) {
		this.coverageType = coverageType;
	}
	public Integer getPolicyHolderId() {
		return policyHolderId;
	}
	public void setPolicyHolderId(Integer policyHolderId) {
		this.policyHolderId = policyHolderId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "PolicyHolder [individualPolicyId=" + individualPolicyId + ", user=" + user + ", policy=" + policy
				+ ", coverageType=" + coverageType + ", policyHolderId=" + policyHolderId + ", fullName=" + fullName
				+ ", mobileNo=" + mobileNo + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + "]";
	}
    
	
	

	
	
	
	
	
	

}
