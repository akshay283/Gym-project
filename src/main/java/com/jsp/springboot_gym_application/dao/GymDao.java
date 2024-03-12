package com.jsp.springboot_gym_application.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.springboot_gym_application.dto.Gym;
import com.jsp.springboot_gym_application.repo.GymRepo;

@Repository
public class GymDao {

	@Autowired
	GymRepo gymRepo;

	public Gym saveGym(Gym gym) {
		return gymRepo.save(gym);
	}

	public Gym updateGym(int id, Gym gym) {
		Optional<Gym> optional = gymRepo.findById(id);
		if (optional.isPresent()) {
			gym.setGymId(id);
			return gymRepo.save(gym);
		} else {
			return null;
		}
	}

	public Gym fetchGymById(int id) {
		Optional<Gym> gym = gymRepo.findById(id);
		if (gym.isPresent()) {
			return gym.get();
		} else {
			return null;
		}
	}

	public List<Gym> fetchAll() {
		return gymRepo.findAll();
	}

	public Gym deleteGym(int id) {
		Optional<Gym> optional = gymRepo.findById(id);
		if (optional.isPresent()) {
			Gym gym = gymRepo.findById(id).get();
			gymRepo.deleteById(id);
			return gym;
		} else {
			return null;
		}
	}
}
