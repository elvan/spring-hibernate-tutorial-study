package com.example.springboot.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.crud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
