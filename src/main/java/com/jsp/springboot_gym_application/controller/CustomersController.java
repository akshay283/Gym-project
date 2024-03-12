package com.jsp.springboot_gym_application.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springboot_gym_application.dto.Customers;
import com.jsp.springboot_gym_application.service.CustomersService;
import com.jsp.springboot_gym_application.util.ResponseStructure;

@RestController
public class CustomersController {

	@Autowired
	CustomersService customersService;

	@PostMapping("/SaveCustomer")
	public ResponseStructure<Customers> saveCustomers(@RequestBody Customers customers) {
		return customersService.saveCustomers(customers);
	}

	@GetMapping("/FetchCustomersAll")
	public ResponseStructure<Customers> fetchAll() {
		return customersService.fetchAll();
	}

	@GetMapping("/FetchCustomersById")
	public ResponseStructure<Customers> fetchById(@RequestParam int id) {
		return customersService.fetchCustomerById(id);
	}

	@PutMapping("/UpdateCustomer")
	public ResponseStructure<Customers> updateCustomer(@RequestParam int id, @RequestBody Customers customers) {
		return customersService.updateCustomer(id, customers);
	}

	@DeleteMapping("/DeleteCustomer")
	public ResponseStructure<Customers> deleteCustomer(@RequestParam int id) {
		return customersService.deleteCustomer(id);
	}
}
