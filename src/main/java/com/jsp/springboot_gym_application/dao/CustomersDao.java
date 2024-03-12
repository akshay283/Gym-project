package com.jsp.springboot_gym_application.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springboot_gym_application.dto.Customers;
import com.jsp.springboot_gym_application.repo.CustomersRepo;

@Repository
public class CustomersDao {

	@Autowired
	CustomersRepo customersRepo;

	public Customers saveCustomers(Customers customers) {
		return customersRepo.save(customers);
	}

	public Customers fetchCustomerById(int id) {
		Optional<Customers> optional = customersRepo.findById(id);
		if (optional.isPresent()) {
			return customersRepo.findById(id).get();
		} else {
			return null;
		}
	}

	public List<Customers> fetchAll() {
		return customersRepo.findAll();
	}

	public Customers deleteCustomers(int id) {
		Optional<Customers> optional = customersRepo.findById(id);
		if (optional.isPresent()) {
			Customers customers = customersRepo.findById(id).get();
			customersRepo.deleteById(id);
			return customers;
		} else {
			return null;
		}
	}

	public Customers updateCustomer(int id, Customers customers) {
		Optional<Customers> optional = customersRepo.findById(id);
		if (optional.isPresent()) {
			customers.setCustomerId(id);
			return customersRepo.save(customers);
		} else {
			return null;
		}
	}
}
