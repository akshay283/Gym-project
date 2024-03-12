package com.jsp.springboot_gym_application.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springboot_gym_application.dto.BranchHead;
import com.jsp.springboot_gym_application.service.BranchHeadService;
import com.jsp.springboot_gym_application.util.ResponseStructure;

@RestController
public class BranchHeadController {

	@Autowired
	BranchHeadService branchHeadService;

	@PostMapping("/SaveBranchHead")
	public ResponseStructure<BranchHead> saveBranchHead(@RequestBody BranchHead branchHead) {
		return branchHeadService.saveBranchHead(branchHead);
	}

	@GetMapping("/FetchBranchHeadById")
	public ResponseStructure<BranchHead> fetchById(@RequestParam int id) {
		return branchHeadService.fetchBranchHeadById(id);
	}

	@GetMapping("/FetchBranchHeadAll")
	public ResponseStructure<BranchHead> fetchAll() {
		return branchHeadService.fetchAll();
	}

	@PutMapping("/UpdateBranchHead")
	public ResponseStructure<BranchHead> updateBranchHead(@RequestParam int id, @RequestBody BranchHead branchHead) {
		return branchHeadService.updateBranchHead(id, branchHead);
	}

	@DeleteMapping("/DeleteBranchHead")
	public ResponseStructure<BranchHead> deleteBranchHead(@RequestParam int id) {
		return branchHeadService.deleteBranchHead(id);
	}
}
