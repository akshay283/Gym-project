package com.jsp.springboot_gym_application.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Trainers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int trainerId;
	private String trainerName;
	private String trainerExperience;
	private double trainerSalary;
	private long trainerPhone;
	private String trainerAddress;

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getTrainerExperience() {
		return trainerExperience;
	}

	public void setTrainerExperience(String trainerExperience) {
		this.trainerExperience = trainerExperience;
	}

	public double getTrainerSalary() {
		return trainerSalary;
	}

	public void setTrainerSalary(double trainerSalary) {
		this.trainerSalary = trainerSalary;
	}

	public long getTrainerPhone() {
		return trainerPhone;
	}

	public void setTrainerPhone(long trainerPhone) {
		this.trainerPhone = trainerPhone;
	}

	public String getTrainerAddress() {
		return trainerAddress;
	}

	public void setTrainerAddress(String trainerAddress) {
		this.trainerAddress = trainerAddress;
	}

}
