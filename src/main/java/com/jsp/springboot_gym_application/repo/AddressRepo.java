package com.jsp.springboot_gym_application.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.springboot_gym_application.dto.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>{

}
