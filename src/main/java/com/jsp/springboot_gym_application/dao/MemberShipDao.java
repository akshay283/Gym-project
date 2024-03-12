package com.jsp.springboot_gym_application.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springboot_gym_application.dto.MemberShip;
import com.jsp.springboot_gym_application.repo.MemberShipRepo;

@Repository
public class MemberShipDao {

	@Autowired
	MemberShipRepo memberShipRepo;

	public MemberShip saveMemberShip(MemberShip memberShip) {
		return memberShipRepo.save(memberShip);
	}

	public MemberShip fetchMemberShipById(int id) {
		Optional<MemberShip> optional = memberShipRepo.findById(id);
		if (optional.isPresent()) {
			return memberShipRepo.findById(id).get();
		} else {
			return null;
		}
	}

	public List<MemberShip> fetchAll() {
		return memberShipRepo.findAll();
	}

	public MemberShip deleteMemberShip(int id) {
		Optional<MemberShip> optional = memberShipRepo.findById(id);
		if (optional.isPresent()) {
			MemberShip memberShip = memberShipRepo.findById(id).get();
			memberShipRepo.deleteById(id);
			return memberShip;
		} else {
			return null;
		}
	}

	public MemberShip updateMemberShip(int id, MemberShip memberShip) {
		Optional<MemberShip> optional = memberShipRepo.findById(id);
		if (optional.isPresent()) {
			memberShip.setMemberShipId(id);
			return memberShipRepo.save(memberShip);
		} else {
			return null;
		}
	}
}
