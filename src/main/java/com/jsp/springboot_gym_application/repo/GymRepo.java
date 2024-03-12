package com.jsp.springboot_gym_application.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.springboot_gym_application.dto.Gym;

public interface GymRepo extends JpaRepository<Gym, Integer>{

}
