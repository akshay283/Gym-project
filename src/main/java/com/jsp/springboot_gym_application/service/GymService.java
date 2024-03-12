package com.jsp.springboot_gym_application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springboot_gym_application.dao.GymDao;
import com.jsp.springboot_gym_application.dto.Gym;
import com.jsp.springboot_gym_application.exception.GymIdNotFound;
import com.jsp.springboot_gym_application.util.ResponseStructure;

@Service
public class GymService {

	@Autowired
	GymDao gymDao;


	public ResponseEntity<ResponseStructure<Gym>> saveGym(Gym gym) {
		ResponseStructure<Gym> responseStructure = new ResponseStructure<Gym>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully inserted gym");
		responseStructure.setData(gymDao.saveGym(gym));
		return new ResponseEntity<ResponseStructure<Gym>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Gym>> fetchById(int id) {
		
		Gym gym=gymDao.fetchGymById(id);
		if(gym!=null)
		{
			ResponseStructure<Gym> responseStructure = new ResponseStructure<Gym>();
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("successfully fetched gym");
			responseStructure.setData(gymDao.fetchGymById(id));
			return new ResponseEntity<ResponseStructure<Gym>>(responseStructure, HttpStatus.FOUND);
		}
		else {
			throw new GymIdNotFound("id not found");
		}
	}

	public ResponseEntity<ResponseStructure<Gym>> fetchAll() {
		ResponseStructure<Gym> responseStructure = new ResponseStructure<Gym>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("Successfully fetched all");
		responseStructure.setDatas(gymDao.fetchAll());
		return new ResponseEntity<ResponseStructure<Gym>>(responseStructure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Gym>> updateGym(int id, Gym gym) {
		ResponseStructure<Gym> responseStructure = new ResponseStructure<Gym>();
		Gym gym2=gymDao.fetchGymById(id);
		if(gym2!=null)
		{
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully updated gym");
		responseStructure.setData(gymDao.updateGym(id, gym));
		return new ResponseEntity<ResponseStructure<Gym>>(responseStructure, HttpStatus.OK);
		}
		else
		{
			throw new GymIdNotFound("Wrong id");
		}
	}

	public ResponseEntity<ResponseStructure<Gym>> deleteGym(int id) {
		Gym gym=gymDao.fetchGymById(id);
		if(gym!=null)
		{
		ResponseStructure<Gym> responseStructure = new ResponseStructure<Gym>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("successfully deleted gym");
		responseStructure.setData(gymDao.deleteGym(id));
		return new ResponseEntity<ResponseStructure<Gym>>(responseStructure, HttpStatus.OK);
		}
		else
		{
			throw  new GymIdNotFound("Entered id is not present in database");
		}
	}
}
