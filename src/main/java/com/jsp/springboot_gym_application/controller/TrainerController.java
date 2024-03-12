package com.jsp.springboot_gym_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springboot_gym_application.dto.Trainers;
import com.jsp.springboot_gym_application.service.TrainersService;
import com.jsp.springboot_gym_application.util.ResponseStructure;

@RestController
public class TrainerController {

	@Autowired
	TrainersService trainersService;

	@PostMapping("/SaveTrainer")
	public ResponseStructure<Trainers> saveTrainer(@RequestBody Trainers trainers) {
		return trainersService.saveTrainers(trainers);
	}

	@GetMapping("/FetchTrainerById")
	public ResponseStructure<Trainers> fetchById(@RequestParam int id) {
		return trainersService.fetchTrainersById(id);
	}

	@GetMapping("/FetchTrainerAll")
	public ResponseStructure<Trainers> fetchAll() {
		return trainersService.fetchAll();
	}

	@PutMapping("/UpdateTrainer")
	public ResponseStructure<Trainers> updateTrainer(@RequestParam int id, @RequestBody Trainers trainers) {
		return trainersService.updateTrainers(id, trainers);
	}

	@DeleteMapping("/DeleteTrainer")
	public ResponseStructure<Trainers> deleteTrainer(@RequestParam int id) {
		return trainersService.deleteTrainer(id);
	}
}
