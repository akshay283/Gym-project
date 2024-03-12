package com.jsp.springboot_gym_application.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class BranchHead {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int branchHeadId;
	private String branchHeadName;
	private double branchHeadSalary;
	private long branchHeadPhone;
	private String branchHeadEmail;
	private  String branchHeadAddress;
	public int getBranchHeadId() {
		return branchHeadId;
	}
	public void setBranchHeadId(int branchHeadId) {
		this.branchHeadId = branchHeadId;
	}
	public String getBranchHeadName() {
		return branchHeadName;
	}
	public void setBranchHeadName(String branchHeadName) {
		this.branchHeadName = branchHeadName;
	}
	public double getBranchHeadSalary() {
		return branchHeadSalary;
	}
	public void setBranchHeadSalary(double branchHeadSalary) {
		this.branchHeadSalary = branchHeadSalary;
	}
	public long getBranchHeadPhone() {
		return branchHeadPhone;
	}
	public void setBranchHeadPhone(long branchHeadPhone) {
		this.branchHeadPhone = branchHeadPhone;
	}
	public String getBranchHeadEmail() {
		return branchHeadEmail;
	}
	public void setBranchHeadEmail(String branchHeadEmail) {
		this.branchHeadEmail = branchHeadEmail;
	}
	public String getBranchHeadAddress() {
		return branchHeadAddress;
	}
	public void setBranchHeadAddress(String branchHeadAddress) {
		this.branchHeadAddress = branchHeadAddress;
	}
	
	
}
