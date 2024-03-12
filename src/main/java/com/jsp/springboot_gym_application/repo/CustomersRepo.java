package com.jsp.springboot_gym_application.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.springboot_gym_application.dto.Customers;

public interface CustomersRepo extends JpaRepository<Customers, Integer> {

}
