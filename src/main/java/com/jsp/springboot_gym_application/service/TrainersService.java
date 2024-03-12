package com.jsp.springboot_gym_application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.springboot_gym_application.dao.TrainersDao;
import com.jsp.springboot_gym_application.dto.Trainers;
import com.jsp.springboot_gym_application.exception.TrainerIdNotFound;
import com.jsp.springboot_gym_application.util.ResponseStructure;

@Service
public class TrainersService {

	@Autowired
	TrainersDao trainersDao;

	public ResponseStructure<Trainers> saveTrainers(Trainers trainers) {
		ResponseStructure<Trainers> responseStructure = new ResponseStructure<Trainers>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("successfully inserted trainer");
		responseStructure.setData(trainersDao.saveTrainer(trainers));
		return responseStructure;
	}

	public ResponseStructure<Trainers> fetchTrainersById(int id) {
		Trainers trainers = trainersDao.fetchTrainerById(id);
		if (trainers != null) {
			ResponseStructure<Trainers> responseStructure = new ResponseStructure<Trainers>();
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("successfully fetched trainer");
			responseStructure.setData(trainersDao.fetchTrainerById(id));
			return responseStructure;
		} else {
			throw new TrainerIdNotFound("Entered trainer Id is incorrect");
		}
	}

	public ResponseStructure<Trainers> fetchAll() {
		ResponseStructure<Trainers> responseStructure = new ResponseStructure<Trainers>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("successfully fetched trainers");
		responseStructure.setDatas(trainersDao.fetchAll());
		return responseStructure;
	}

	public ResponseStructure<Trainers> deleteTrainer(int id) {
		Trainers trainers = trainersDao.fetchTrainerById(id);
		if (trainers != null) {
			ResponseStructure<Trainers> responseStructure = new ResponseStructure<Trainers>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("successfully deleted trainer");
			responseStructure.setData(trainersDao.deleteTrainer(id));
			return responseStructure;
		} else {
			throw new TrainerIdNotFound("Entered trainer Id is incorrect");
		}
	}

	public ResponseStructure<Trainers> updateTrainers(int id, Trainers trainers) {
		Trainers trainers2 = trainersDao.fetchTrainerById(id);
		if (trainers2 != null) {
			ResponseStructure<Trainers> responseStructure = new ResponseStructure<Trainers>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("successfully updated trainer");
			responseStructure.setData(trainersDao.updateTrainer(id, trainers));
			return responseStructure;
		} else {
			throw new TrainerIdNotFound("Entered trainer Id is incorrect");
		}
	}
}
