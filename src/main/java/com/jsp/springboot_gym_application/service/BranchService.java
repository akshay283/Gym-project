package com.jsp.springboot_gym_application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.springboot_gym_application.dao.AddressDao;
import com.jsp.springboot_gym_application.dao.BranchDao;
import com.jsp.springboot_gym_application.dao.CustomersDao;
import com.jsp.springboot_gym_application.dto.Address;
import com.jsp.springboot_gym_application.dto.Branch;
import com.jsp.springboot_gym_application.dto.Customers;
import com.jsp.springboot_gym_application.exception.AddressIdNotFound;
import com.jsp.springboot_gym_application.exception.BranchIdNotFound;
import com.jsp.springboot_gym_application.exception.CustomerIdNotFound;
import com.jsp.springboot_gym_application.util.ResponseStructure;

@Service
public class BranchService {

	@Autowired
	BranchDao branchDao;
	@Autowired
	AddressDao addressDao;
	@Autowired
	CustomersDao customersDao;

	public ResponseStructure<Branch> saveBranch(Branch branch) {
		ResponseStructure<Branch> responseStructure = new ResponseStructure<Branch>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Succesfully inserted branch");
		responseStructure.setData(branchDao.saveBranch(branch));
		return responseStructure;
	}

	public ResponseStructure<Branch> fetchBranchById(int id) {
		Branch branch = branchDao.fetchBranchById(id);
		if (branch != null) {
			ResponseStructure<Branch> responseStructure = new ResponseStructure<Branch>();
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Succesfully fetched branch");
			responseStructure.setData(branchDao.fetchBranchById(id));
			return responseStructure;
		} else {
			throw new BranchIdNotFound("Please enter correct brach ID");
		}
	}

	public ResponseStructure<Branch> fetchAll() {
		ResponseStructure<Branch> responseStructure = new ResponseStructure<Branch>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Succesfully fetched all");
		responseStructure.setDatas(branchDao.fetchAll());
		return responseStructure;
	}

	public ResponseStructure<Branch> updateBranch(int id, Branch branch) {
		Branch branch2 = branchDao.fetchBranchById(id);
		if (branch2 != null) {
			ResponseStructure<Branch> responseStructure = new ResponseStructure<Branch>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Sucessfully updated");
			responseStructure.setData(branchDao.updateBranch(id, branch));
			return responseStructure;
		} else {
			throw new BranchIdNotFound("Please enter correct brach ID");
		}
	}

	public ResponseStructure<Branch> deleteBranch(int id) {
		Branch branch = branchDao.fetchBranchById(id);
		if (branch != null) {
			ResponseStructure<Branch> responseStructure = new ResponseStructure<Branch>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Succesfully deleted");
			responseStructure.setData(branchDao.deleteBranch(id));
			return responseStructure;
		} else {
			throw new BranchIdNotFound("Please enter correct brach ID");
		}
	}

	public ResponseStructure<Branch> addExistingAddressToExistingBranch(int branchId, int addressId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		Address address = addressDao.fetchAddressById(addressId);
		if (branch != null && address != null) {
			ResponseStructure<Branch> responseStructure = new ResponseStructure<Branch>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("succesfully added address to branch");
			responseStructure.setData(branchDao.addExistingAddressToExistingBranch(branchId, addressId));
			return responseStructure;
		} else if (branch == null) {
			throw new BranchIdNotFound("Invalid branch Id");
		} else {
			throw new AddressIdNotFound("Invalid address Id");
		}
	}

	public ResponseStructure<Branch> addNewAddressToExistingBranch(int branchId, Address address) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			ResponseStructure<Branch> responseStructure = new ResponseStructure<Branch>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("succesfully added address to branch");
			responseStructure.setData(branchDao.addNewAddressToExistingBranch(address, branchId));
			return responseStructure;
		} else {
			throw new BranchIdNotFound("Please enter valid branch Id");
		}
	}

	public ResponseStructure<Branch> addNewCustomerToExistingBranch(int branchId, List<Customers> customers) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			ResponseStructure<Branch> responseStructure = new ResponseStructure<Branch>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("successfully customer added to branch");
			responseStructure.setData(branchDao.addNewCustomerToExistingBranch(branchId, customers));
			return responseStructure;
		} else {
			throw new BranchIdNotFound("invalid branch Id");
		}
	}

	public ResponseStructure<Branch> addExistingCustomerToExistingBranch(int branchId, int customersId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		Customers customers = customersDao.fetchCustomerById(customersId);
		if (branch != null && customers != null) {
			ResponseStructure<Branch> responseStructure = new ResponseStructure<Branch>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setData(branchDao.addExistingCustomersToExistingBranch(branchId, customersId));
			return responseStructure;
		} else if (customers == null) {
			throw new CustomerIdNotFound("Invalid customerId");
		} else {
			throw new BranchIdNotFound("Invalid branch Id");
		}
	}
}
