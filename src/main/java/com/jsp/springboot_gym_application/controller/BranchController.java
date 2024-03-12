package com.jsp.springboot_gym_application.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springboot_gym_application.dto.Address;
import com.jsp.springboot_gym_application.dto.Branch;
import com.jsp.springboot_gym_application.dto.Customers;
import com.jsp.springboot_gym_application.service.BranchService;
import com.jsp.springboot_gym_application.util.ResponseStructure;

@RestController
public class BranchController {

	@Autowired
	BranchService branchService;

	@PostMapping("/SaveBranch")
	public ResponseStructure<Branch> saveBranch(@RequestBody Branch branch) {
		return branchService.saveBranch(branch);
	}
	@GetMapping("/AddExistingAddressToExistingBranch")
	public ResponseStructure<Branch> addExistingAddressToExistingBranch(@RequestParam int branchId,@RequestParam int addressId)
	{
		return branchService.addExistingAddressToExistingBranch(branchId, addressId);
	}
	@PostMapping("/NewAddressToBranch")
	public ResponseStructure<Branch> addNewAddressToExistingBranch(@RequestParam int branchId,@RequestBody Address address)
	{
		return branchService.addNewAddressToExistingBranch(branchId, address);
	}
	@PutMapping("/UpdateBranch")
	public ResponseStructure<Branch> updateBranch(@RequestParam int id,@RequestBody Branch branch) {
		return branchService.updateBranch(id, branch);
	}

	@GetMapping("/FetchBranchAll")
	public ResponseStructure<Branch> fetchAll() {
		return branchService.fetchAll();
	}

	@GetMapping("/FetchBranchById")
	public ResponseStructure<Branch> fetchById(@RequestParam int id) {
		return branchService.fetchBranchById(id);
	}

	@DeleteMapping("/DeleteBranch")
	public ResponseStructure<Branch> deleteById(@RequestParam int id) {
		return branchService.deleteBranch(id);
	}
	@PostMapping("/NewCustomerToBranch")
	public ResponseStructure<Branch> addNewCustomerToExistingBranch(@RequestParam int branchId,@RequestBody List<Customers> customers)
	{
		return branchService.addNewCustomerToExistingBranch(branchId, customers);
	}
}
