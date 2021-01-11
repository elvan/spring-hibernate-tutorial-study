package com.example.springboot.crud.service;

import java.util.List;

import com.example.springboot.crud.entity.Employee;

public interface EmployeeService {

  public List<Employee> findAll();

  public Employee findById(int id);

  public void save(Employee employee);

  public void deleteById(int id);

}
