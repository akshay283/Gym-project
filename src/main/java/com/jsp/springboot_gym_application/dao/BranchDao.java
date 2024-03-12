package com.jsp.springboot_gym_application.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springboot_gym_application.dto.Address;
import com.jsp.springboot_gym_application.dto.Branch;
import com.jsp.springboot_gym_application.dto.BranchHead;
import com.jsp.springboot_gym_application.dto.Customers;
import com.jsp.springboot_gym_application.dto.MemberShip;
import com.jsp.springboot_gym_application.dto.Trainers;
import com.jsp.springboot_gym_application.repo.AddressRepo;
import com.jsp.springboot_gym_application.repo.BranchRepo;

@Repository
public class BranchDao {

	@Autowired
	BranchRepo branchRepo;
	@Autowired
	AddressDao addressDao;
	@Autowired
	CustomersDao customersDao;
	@Autowired
	TrainersDao trainersDao;
	@Autowired
	AddressRepo addressRepo;
	@Autowired
	MemberShipDao memberShipDao;
	@Autowired
	BranchHeadDao branchHeadDao;

	public Branch saveBranch(Branch branch) {
		return branchRepo.save(branch);
	}

	public Branch fetchBranchById(int id) {
		Optional<Branch> optional = branchRepo.findById(id);
		if (optional.isPresent()) {
			return branchRepo.findById(id).get();
		} else {
			return null;
		}
	}

	public List<Branch> fetchAll() {
		return branchRepo.findAll();
	}

	public Branch deleteBranch(int id) {
		Optional<Branch> optional = branchRepo.findById(id);
		if (optional.isPresent()) {
			Branch branch = branchRepo.findById(id).get();
			branchRepo.deleteById(id);
			return branch;
		} else {
			return null;
		}
	}

	public Branch updateBranch(int id, Branch branch) {
		Optional<Branch> optional = branchRepo.findById(id);
		if (optional.isPresent()) {
			branch.setBranchId(id);
			return branchRepo.save(branch);
		} else {
			return null;
		}
	}

	public Branch addExistingAddressToExistingBranch(int branchId, int addressId) {
		Optional<Branch> optional = branchRepo.findById(branchId);
		Optional<Address> optional2 = addressRepo.findById(addressId);
		if (optional.isPresent() && optional2.isPresent()) {
			Branch branch = fetchBranchById(branchId);
			Address address = addressDao.fetchAddressById(addressId);
			branch.setAddress(address);
			return branchRepo.save(branch);
		} else {
			return null;
		}
	}

	public Branch addNewAddressToExistingBranch(Address address, int branchId) {
		Branch branch = fetchBranchById(branchId);
		branch.setAddress(address);
		return branchRepo.save(branch);
	}

	public Branch addExistingCustomersToExistingBranch(int branchId, int customersId) {
		Branch branch = fetchBranchById(branchId);
		List<Customers> list = new ArrayList<Customers>();
		Customers customers = customersDao.fetchCustomerById(customersId);
		list.add(customers);
		branch.setCustomers(list);
		return branchRepo.save(branch);
	}

	public Branch addNewCustomerToExistingBranch(int branchId, List<Customers> customers) {
		Branch branch = fetchBranchById(branchId);
//		List<Customers> list = new ArrayList<Customers>();
//		for (Customers customers2 : customers) {
//			list.add(customers2);
//		}
		branch.getCustomers().addAll(customers);

		return saveBranch(branch);
	}

	public Branch addExistingTrainerToExistingBranch(int branchId, int trainerId) {
		Branch branch = fetchBranchById(branchId);
		List<Trainers> list = new ArrayList<Trainers>();
		Trainers trainers = trainersDao.fetchTrainerById(trainerId);
		list.add(trainers);
		branch.setTrainers(list);
		return saveBranch(branch);
	}

	public Branch addNewTrainerToExistingBranch(List<Trainers> trainers, int branchId) {
		Branch branch = fetchBranchById(branchId);
//		List<Trainers> list=new ArrayList<Trainers>();
//		for(Trainers trainers2:trainers)
//		{
//			list.add(trainers2);
//		}
		branch.getTrainers().addAll(trainers);
		return saveBranch(branch);
	}

	public Branch addExistingMemberShipToExistingBranch(int branchId, int memberShipId) {
		Branch branch = fetchBranchById(branchId);
		List<MemberShip> list = new ArrayList<MemberShip>();
		MemberShip memberShip = memberShipDao.fetchMemberShipById(memberShipId);
		list.add(memberShip);
		branch.setMemberShips(list);
		return saveBranch(branch);
	}

	public Branch addNewMemberShipToExistingBranch(int branchId, List<MemberShip> memberShips) {
		Branch branch = fetchBranchById(branchId);
		branch.getMemberShips().addAll(memberShips);
		return saveBranch(branch);
	}

	public Branch addNewBranchHeadToExistingBranch(int branchId, BranchHead branchHead) {
		Branch branch = fetchBranchById(branchId);
		branch.setBranchHead(branchHead);
		return saveBranch(branch);
	}

	public Branch addExistingBranchHeadToExistingBranch(int branchId, int branchHeadId) {
		Branch branch = fetchBranchById(branchId);
		BranchHead branchHead = branchHeadDao.fetchBranchHeadById(branchHeadId);
		branch.setBranchHead(branchHead);
		return saveBranch(branch);
	}

}
