package com.example.springboot.crud.repository;

import java.util.List;

import com.example.springboot.crud.entity.Employee;

public interface EmployeeRepository {

  public List<Employee> findAll();

  public Employee findById(int id);

  public void save(Employee employee);

  public void deleteById(int id);

}
