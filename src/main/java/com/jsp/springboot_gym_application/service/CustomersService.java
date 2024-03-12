package com.jsp.springboot_gym_application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.springboot_gym_application.dao.CustomersDao;
import com.jsp.springboot_gym_application.dto.Customers;
import com.jsp.springboot_gym_application.exception.CustomerIdNotFound;
import com.jsp.springboot_gym_application.util.ResponseStructure;

@Service
public class CustomersService {

	@Autowired
	CustomersDao customersDao;

	public ResponseStructure<Customers> saveCustomers(Customers customers) {
		ResponseStructure<Customers> responseStructure = new ResponseStructure<Customers>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Sucessfully inserted customer");
		responseStructure.setData(customersDao.saveCustomers(customers));
		return responseStructure;
	}

	public ResponseStructure<Customers> fetchCustomerById(int id) {
		Customers customers = customersDao.fetchCustomerById(id);
		if (customers != null) {
			ResponseStructure<Customers> responseStructure = new ResponseStructure<Customers>();
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Sucessfully fetched customer");
			responseStructure.setData(customersDao.fetchCustomerById(id));
			return responseStructure;
		} else {
			throw new CustomerIdNotFound("Please enter valid customet ID");

		}
	}

	public ResponseStructure<Customers> fetchAll() {
		ResponseStructure<Customers> responseStructure = new ResponseStructure<Customers>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Sucessfully fetched customer");
		responseStructure.setDatas(customersDao.fetchAll());
		return responseStructure;
	}

	public ResponseStructure<Customers> updateCustomer(int id, Customers customers) {
		Customers customers2 = customersDao.fetchCustomerById(id);
		if (customers2 != null) {
			ResponseStructure<Customers> responseStructure = new ResponseStructure<Customers>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Sucessfully updated customer");
			responseStructure.setData(customersDao.updateCustomer(id, customers));
			return responseStructure;
		} else {
			throw new CustomerIdNotFound("Please enter valid customet ID");

		}
	}

	public ResponseStructure<Customers> deleteCustomer(int id) {
		Customers customers = customersDao.fetchCustomerById(id);
		if (customers != null) {
			ResponseStructure<Customers> responseStructure = new ResponseStructure<Customers>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("successfully deleted customer");
			responseStructure.setData(customersDao.deleteCustomers(id));
			return responseStructure;
		} else {
			throw new CustomerIdNotFound("Please enter valid customet ID");

		}
	}
}
