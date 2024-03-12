package com.jsp.springboot_gym_application.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springboot_gym_application.dto.BranchHead;
import com.jsp.springboot_gym_application.repo.BranchHeadRepo;

@Repository
public class BranchHeadDao {

	@Autowired
	BranchHeadRepo branchHeadRepo;

	public BranchHead saveBranchHead(BranchHead branchHead) {
		return branchHeadRepo.save(branchHead);
	}

	public BranchHead fetchBranchHeadById(int id) {
		Optional<BranchHead> optional = branchHeadRepo.findById(id);
		if (optional.isPresent()) {
			return branchHeadRepo.findById(id).get();
		} else {
			return null;
		}
	}

	public List<BranchHead> fetchAll() {
		return branchHeadRepo.findAll();
	}

	public BranchHead deletBranchHead(int id) {
		Optional<BranchHead> optional = branchHeadRepo.findById(id);
		if (optional.isPresent()) {
			BranchHead branchHead = branchHeadRepo.findById(id).get();
			branchHeadRepo.deleteById(id);
			return branchHead;
		} else {
			return null;
		}
	}

	public BranchHead updateBranchHead(int id, BranchHead branchHead) {
		Optional<BranchHead> optional = branchHeadRepo.findById(id);
		if (optional.isPresent()) {
			branchHead.setBranchHeadId(id);
			return branchHeadRepo.save(branchHead);
		} else {
			return null;
		}
	}
}
