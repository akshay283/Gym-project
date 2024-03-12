package com.jsp.springboot_gym_application.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class MemberShip {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int memberShipId;
	private String memberShipName;
	private double memberShipPrice;
	private String memberShipDuration;
	private String memberShipDiscount;

	public int getMemberShipId() {
		return memberShipId;
	}

	public void setMemberShipId(int memberShipId) {
		this.memberShipId = memberShipId;
	}

	public String getMemberShipName() {
		return memberShipName;
	}

	public void setMemberShipName(String memberShipName) {
		this.memberShipName = memberShipName;
	}

	public double getMemberShipPrice() {
		return memberShipPrice;
	}

	public void setMemberShipPrice(double memberShipPrice) {
		this.memberShipPrice = memberShipPrice;
	}

	public String getMemberShipDuration() {
		return memberShipDuration;
	}

	public void setMemberShipDuration(String memberShipDuration) {
		this.memberShipDuration = memberShipDuration;
	}

	public String getMemberShipDiscount() {
		return memberShipDiscount;
	}

	public void setMemberShipDiscount(String memberShipDiscount) {
		this.memberShipDiscount = memberShipDiscount;
	}

}
