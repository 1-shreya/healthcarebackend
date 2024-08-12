package com.example.Healthcare.Entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "family_members")

public class FamilyMember {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int member_id;
	private String fullname;
	private Date date_of_birth;
	private String gender;
	private int mobile_number;
	private String relationship;
	private String occupation;
	
	public FamilyMember() {
		// TODO Auto-generated constructor stub
	}

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(int mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	@Override
	public String toString() {
		return "FamilyMember [member_id=" + member_id + ", fullname=" + fullname + ", date_of_birth=" + date_of_birth
				+ ", gender=" + gender + ", mobile_number=" + mobile_number + ", relationship=" + relationship
				+ ", occupation=" + occupation + "]";
	}
	
	
	

}
