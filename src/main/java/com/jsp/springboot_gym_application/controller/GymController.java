package com.jsp.springboot_gym_application.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springboot_gym_application.dto.Gym;
import com.jsp.springboot_gym_application.service.GymService;
import com.jsp.springboot_gym_application.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class GymController {

	@Autowired
	GymService gymService;

	@ApiOperation(value = "save gym",notes = "Api is used for saving " )
	@ApiResponses({ @ApiResponse(code = 201, message = "Employee saved Successfully"),
				@ApiResponse(code = 400, message = "fields cannot be null or blank") })	
	@PostMapping("/SaveGym")
	public ResponseEntity<ResponseStructure<Gym>> saveGym(@Valid @RequestBody Gym gym) {
		return gymService.saveGym(gym);
	}

	@GetMapping("/FetchGym")
	public ResponseEntity<ResponseStructure<Gym>> fetchById(@RequestParam int id) {
		return gymService.fetchById(id);
	}

	@GetMapping("/FetchGymAll")
	public ResponseEntity<ResponseStructure<Gym>> fetchAll() {
		return gymService.fetchAll();
	}

	@PutMapping("/UpdateGym")
	public ResponseEntity<ResponseStructure<Gym>> updateGym(@RequestParam int id, @RequestBody Gym gym) {
		return gymService.updateGym(id, gym);
	}

	@DeleteMapping("/DeleteGym")
	public ResponseEntity<ResponseStructure<Gym>> deleteGym(@RequestParam int id) {
		return gymService.deleteGym(id);
	}
}
