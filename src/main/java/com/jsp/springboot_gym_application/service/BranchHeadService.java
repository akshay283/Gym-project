package com.jsp.springboot_gym_application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.springboot_gym_application.dao.BranchHeadDao;
import com.jsp.springboot_gym_application.dto.BranchHead;
import com.jsp.springboot_gym_application.exception.BranchHeadIdNotFound;
import com.jsp.springboot_gym_application.util.ResponseStructure;

@Service
public class BranchHeadService {

	@Autowired
	BranchHeadDao branchHeadDao;

	public ResponseStructure<BranchHead> saveBranchHead(BranchHead branchHead) {
		ResponseStructure<BranchHead> responseStructure = new ResponseStructure<BranchHead>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Succesfully inserted");
		responseStructure.setData(branchHeadDao.saveBranchHead(branchHead));
		return responseStructure;
	}

	public ResponseStructure<BranchHead> fetchBranchHeadById(int id) {
		BranchHead branchHead = branchHeadDao.fetchBranchHeadById(id);
		if (branchHead != null) {
			ResponseStructure<BranchHead> responseStructure = new ResponseStructure<BranchHead>();
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Succesfully fetched branch head");
			responseStructure.setData(branchHeadDao.fetchBranchHeadById(id));
			return responseStructure;
		} else {
			throw new BranchHeadIdNotFound("Entered BranchHead Id is incorrect");
		}
	}

	public ResponseStructure<BranchHead> fetchAll() {
		ResponseStructure<BranchHead> responseStructure = new ResponseStructure<BranchHead>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Succesfully fetched all");
		responseStructure.setDatas(branchHeadDao.fetchAll());
		return responseStructure;

	}

	public ResponseStructure<BranchHead> deleteBranchHead(int id) {
		BranchHead branchHead = branchHeadDao.fetchBranchHeadById(id);
		if (branchHead != null) {
			ResponseStructure<BranchHead> responseStructure = new ResponseStructure<BranchHead>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Succesfully deleted branch head");
			responseStructure.setData(branchHeadDao.deletBranchHead(id));
			return responseStructure;
		} else {
			throw new BranchHeadIdNotFound("Entered BranchHead Id is incorrect");
		}
	}

	public ResponseStructure<BranchHead> updateBranchHead(int id, BranchHead branchHead) {
		BranchHead branchHead2 = branchHeadDao.fetchBranchHeadById(id);
		if (branchHead2 != null) {
			ResponseStructure<BranchHead> responseStructure = new ResponseStructure<BranchHead>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Succesfully updated branch head");
			responseStructure.setData(branchHeadDao.updateBranchHead(id, branchHead));
			return responseStructure;
		} else {
			throw new BranchHeadIdNotFound("Entered BranchHead Id is incorrect");
		}
	}
}
