package com.jsp.springboot_gym_application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.springboot_gym_application.dao.MemberShipDao;
import com.jsp.springboot_gym_application.dto.MemberShip;
import com.jsp.springboot_gym_application.exception.MemberShipIdNotFound;
import com.jsp.springboot_gym_application.util.ResponseStructure;

@Service
public class MemberShipService {

	@Autowired
	MemberShipDao memberShipDao;

	public ResponseStructure<MemberShip> saveMemberShip(MemberShip memberShip) {
		ResponseStructure<MemberShip> responseStructure = new ResponseStructure<MemberShip>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("successfully inserted membership");
		responseStructure.setData(memberShipDao.saveMemberShip(memberShip));
		return responseStructure;
	}

	public ResponseStructure<MemberShip> fetchMemberShipById(int id) {
		MemberShip memberShip = memberShipDao.fetchMemberShipById(id);
		if (memberShip != null) {
			ResponseStructure<MemberShip> responseStructure = new ResponseStructure<MemberShip>();
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("successfully fetched membership");
			responseStructure.setData(memberShipDao.fetchMemberShipById(id));
			return responseStructure;
		} else {
			throw new MemberShipIdNotFound("Invalid membership Id");
		}
	}

	public ResponseStructure<MemberShip> fetchAll() {
		ResponseStructure<MemberShip> responseStructure = new ResponseStructure<MemberShip>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("successfully fetched all");
		responseStructure.setDatas(memberShipDao.fetchAll());
		return responseStructure;
	}

	public ResponseStructure<MemberShip> updateMemberShip(int id, MemberShip memberShip) {
		MemberShip memberShip2 = memberShipDao.fetchMemberShipById(id);
		if (memberShip2 != null) {
			ResponseStructure<MemberShip> responseStructure = new ResponseStructure<MemberShip>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("successfully updated membership");
			responseStructure.setData(memberShipDao.updateMemberShip(id, memberShip));
			return responseStructure;
		} else {
			throw new MemberShipIdNotFound("Invalid membership Id");
		}
	}

	public ResponseStructure<MemberShip> deleteMemberShip(int id) {
		MemberShip memberShip = memberShipDao.fetchMemberShipById(id);
		if (memberShip != null) {
			ResponseStructure<MemberShip> responseStructure = new ResponseStructure<MemberShip>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("successfully deleted membership");
			responseStructure.setData(memberShipDao.deleteMemberShip(id));
			return responseStructure;
		} else {
			throw new MemberShipIdNotFound("Invalid membership Id");
		}
	}
}
