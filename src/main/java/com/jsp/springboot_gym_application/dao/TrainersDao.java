package com.jsp.springboot_gym_application.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springboot_gym_application.dto.Trainers;
import com.jsp.springboot_gym_application.repo.TrainersRepo;

@Repository
public class TrainersDao {

	@Autowired
	TrainersRepo trainersRepo;

	public Trainers saveTrainer(Trainers trainers) {
		return trainersRepo.save(trainers);
	}

	public Trainers fetchTrainerById(int id) {
		Optional<Trainers> optional = trainersRepo.findById(id);
		if (optional.isPresent()) {
			return trainersRepo.findById(id).get();
		} else {
			return null;
		}
	}

	public List<Trainers> fetchAll() {
		return trainersRepo.findAll();
	}

	public Trainers updateTrainer(int id, Trainers trainers) {
		Optional<Trainers> optional = trainersRepo.findById(id);
		if (optional.isPresent()) {
			trainers.setTrainerId(id);
			return trainersRepo.save(trainers);
		} else {
			return null;
		}
	}

	public Trainers deleteTrainer(int id) {
		Optional<Trainers> optional = trainersRepo.findById(id);
		if (optional.isPresent()) {
			Trainers trainers = trainersRepo.findById(id).get();
			trainersRepo.deleteById(id);
			return trainers;
		} else {
			return null;
		}
	}

}
