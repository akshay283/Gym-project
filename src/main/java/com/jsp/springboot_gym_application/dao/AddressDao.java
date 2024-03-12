package com.jsp.springboot_gym_application.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springboot_gym_application.dto.Address;
import com.jsp.springboot_gym_application.repo.AddressRepo;

@Repository
public class AddressDao {

	@Autowired
	AddressRepo addressRepo;

	public Address saveAddress(Address address) {
		return addressRepo.save(address);
	}

	public Address fetchAddressById(int id) {
		Optional<Address> optional = addressRepo.findById(id);
		if (optional.isPresent()) {
			return addressRepo.findById(id).get();
		} else {
			return null;
		}
	}

	public List<Address> fetchAll() {
		return addressRepo.findAll();
	}

	public Address updateAddress(int id, Address address) {
		Optional<Address> optional = addressRepo.findById(id);
		if (optional.isPresent()) {
			address.setAddressId(id);
			return addressRepo.save(address);
		} else {
			return null;
		}
	}

	public Address deleteAddress(int id) {
		Optional<Address> optional = addressRepo.findById(id);
		if (optional.isPresent()) {
			Address address = addressRepo.findById(id).get();
			addressRepo.deleteById(id);
			return address;
		} else {
			return null;
		}
	}
}
