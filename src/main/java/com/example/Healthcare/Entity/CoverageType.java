package com.example.Healthcare.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "Coverage_Type")
public class CoverageType {
	@Id
	private int coverage_id;
	private int adult;
	private int children;
	private String type;

	public CoverageType() {
		// TODO Auto-generated constructor stub
	}

	public CoverageType(int coverage_id, int adult, int children, String type) {
		super();
		this.coverage_id = coverage_id;
		this.adult = adult;
		this.children = children;
		this.type = type;
	}

	public int getCoverage_id() {
		return coverage_id;
	}

	public void setCoverage_id(int coverage_id) {
		this.coverage_id = coverage_id;
	}

	public int getAdult() {
		return adult;
	}

	public void setAdult(int adult) {
		this.adult = adult;
	}

	public int getChildren() {
		return children;
	}

	public void setChildren(int children) {
		this.children = children;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "CoverageType [coverage_id=" + coverage_id + ", adult=" + adult + ", children=" + children + ", type="
				+ type + "]";
	}
	
	

}
