package com.example.springboot.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
  public List<Employee> findAllByOrderByLastNameAsc();
}
