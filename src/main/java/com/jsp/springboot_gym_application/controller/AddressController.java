package com.jsp.springboot_gym_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springboot_gym_application.dto.Address;
import com.jsp.springboot_gym_application.service.AddressService;
import com.jsp.springboot_gym_application.util.ResponseStructure;

@RestController
public class AddressController {

	@Autowired
	AddressService addressService;

	@PostMapping("/SaveAddress")
	public ResponseStructure<Address> saveAddress(@RequestBody Address address) {
		return addressService.saveAddress(address);
	}

	@GetMapping("/FetchAddressById")
	public ResponseStructure<Address> fetchById(@RequestParam int id) {
		return addressService.fetchAddressById(id);
	}

	@GetMapping("/FetchAddressAll")
	public ResponseStructure<Address> fetchAll() {
		return addressService.fetchAll();
	}

	@PutMapping("/UpdateAddress")
	public ResponseStructure<Address> updateAddress(@RequestParam int id, @RequestBody Address address) {
		return addressService.updateAddress(id, address);
	}

	@DeleteMapping("/DeleteAddress")
	public ResponseStructure<Address> deleteAddress(@RequestParam int id) {
		return addressService.deleteAddress(id);
	}
}
