package com.jsp.springboot_gym_application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.springboot_gym_application.dao.AddressDao;
import com.jsp.springboot_gym_application.dto.Address;
import com.jsp.springboot_gym_application.exception.AddressIdNotFound;
import com.jsp.springboot_gym_application.util.ResponseStructure;

@Service
public class AddressService {

	@Autowired
	AddressDao addressDao;

	public ResponseStructure<Address> saveAddress(Address address) {
		ResponseStructure<Address> responseStructure = new ResponseStructure<Address>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Succesfully saved address");
		responseStructure.setData(addressDao.saveAddress(address));
		return responseStructure;
	}

	public ResponseStructure<Address> fetchAddressById(int id) {
		Address address = addressDao.fetchAddressById(id);
		if (address != null) {
			ResponseStructure<Address> responseStructure = new ResponseStructure<Address>();
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Succesfully fetched address");
			responseStructure.setData(addressDao.fetchAddressById(id));
			return responseStructure;
		} else {
			throw new AddressIdNotFound("Given address ID is not found");
		}
	}

	public ResponseStructure<Address> fetchAll() {
		ResponseStructure<Address> responseStructure = new ResponseStructure<Address>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Succesfully fetched all addresses");
		responseStructure.setDatas(addressDao.fetchAll());
		return responseStructure;
	}

	public ResponseStructure<Address> updateAddress(int id, Address address) {
		Address address2 = addressDao.fetchAddressById(id);
		if (address2 != null) {
			ResponseStructure<Address> responseStructure = new ResponseStructure<Address>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("succesfully updated address");
			responseStructure.setData(addressDao.updateAddress(id, address));
			return responseStructure;
		} else {
			throw new AddressIdNotFound("Given Address Id is invalid");
		}
	}

	public ResponseStructure<Address> deleteAddress(int id) {
		Address address = addressDao.fetchAddressById(id);
		if (address != null) {
			ResponseStructure<Address> responseStructure = new ResponseStructure<Address>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Succesfully deleted address");
			responseStructure.setData(addressDao.deleteAddress(id));
			return responseStructure;
		} else {
			throw new AddressIdNotFound("Given Address Id is invalid");
		}
	}
}
