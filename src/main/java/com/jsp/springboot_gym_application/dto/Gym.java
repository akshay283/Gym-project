package com.jsp.springboot_gym_application.dto;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Gym {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int gymId;
	@NotNull(message="name should not be null")
	@NotBlank(message = "name should not be blank")
	private String gymName;
	private String gymGst;
	@NotNull(message="name should not be null")
	@NotBlank(message = "name should not be blank")
	private String gymOwner;
	@Min(6000000000l)
	@Max(9999999999l)
	private long gymPhone;
	private String gymWebsite;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Branch> branchs;

	public int getGymId() {
		return gymId;
	}
	public void setGymId(int gymId) {
		this.gymId = gymId;
	}
	public String getGymName() {
		return gymName;
	}
	public void setGymName(String gymName) {
		this.gymName = gymName;
	}
	public String getGymGst() {
		return gymGst;
	}
	public void setGymGst(String gymGst) {
		this.gymGst = gymGst;
	}
	public String getGymOwner() {
		return gymOwner;
	}
	public void setGymOwner(String gymOwner) {
		this.gymOwner = gymOwner;
	}
	public long getGymPhone() {
		return gymPhone;
	}
	public void setGymPhone(long gymPhone) {
		this.gymPhone = gymPhone;
	}
	public String getGymWebsite() {
		return gymWebsite;
	}
	public void setGymWebsite(String gymWebsite) {
		this.gymWebsite = gymWebsite;
	}
	public List<Branch> getBranchs() {
		return branchs;
	}
	public void setBranchs(List<Branch> branchs) {
		this.branchs = branchs;
	}
	
	
}
