package com.example.Healthcare.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Family_Members_user")
public class FamilyMemberUser {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	private int familymemberid;
	public FamilyMemberUser() {
		// TODO Auto-generated constructor stub
	}
	public FamilyMemberUser(int user_id, int familymemberid) {
		super();
		this.user_id = user_id;
		this.familymemberid = familymemberid;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getFamilymemberid() {
		return familymemberid;
	}
	public void setFamilymemberid(int familymemberid) {
		this.familymemberid = familymemberid;
	}
	@Override
	public String toString() {
		return "FamilyMemberUser [user_id=" + user_id + ", familymemberid=" + familymemberid + "]";
	}
	
	
	

}
