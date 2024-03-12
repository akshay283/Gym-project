package com.jsp.springboot_gym_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springboot_gym_application.dto.MemberShip;
import com.jsp.springboot_gym_application.service.MemberShipService;
import com.jsp.springboot_gym_application.util.ResponseStructure;

@RestController
public class MemberShipController {

	@Autowired
	MemberShipService memberShipService;

	@PostMapping("/SaveMemberShip")
	public ResponseStructure<MemberShip> saveMemberShip(@RequestBody MemberShip memberShip) {
		return memberShipService.saveMemberShip(memberShip);
	}

	@GetMapping("/FetchMemberShipById")
	public ResponseStructure<MemberShip> fetchById(@RequestParam int id) {
		return memberShipService.fetchMemberShipById(id);
	}

	@GetMapping("/FetchMemberShipAll")
	public ResponseStructure<MemberShip> fetchAll() {
		return memberShipService.fetchAll();
	}

	@PutMapping("/UpdateMemberShip")
	public ResponseStructure<MemberShip> updateMemberShip(@RequestParam int id, @RequestBody MemberShip memberShip) {
		return memberShipService.updateMemberShip(id, memberShip);
	}

	@DeleteMapping("/DeleteMemberShip")
	public ResponseStructure<MemberShip> deleteMemberShip(@RequestParam int id) {
		return memberShipService.deleteMemberShip(id);
	}
}
