package com.example.springboot.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springboot.crud.entity.Employee;
import com.example.springboot.crud.repository.EmployeeRepository;

@Service
public class DefaultEmployeeService implements EmployeeService {

  private EmployeeRepository employeeRepository;

  @Autowired
  public DefaultEmployeeService(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  @Transactional
  public List<Employee> findAll() {
    return employeeRepository.findAll();
  }

  @Override
  @Transactional
  public Employee findById(int id) {
    return employeeRepository.findById(id);
  }

  @Override
  @Transactional
  public void save(Employee employee) {
    employeeRepository.save(employee);
  }

  @Override
  @Transactional
  public void deleteById(int id) {
    employeeRepository.deleteById(id);
  }

}
