package com.example.springboot.crud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.crud.entity.Employee;
import com.example.springboot.crud.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

  private EmployeeService employeeService;

  @Autowired
  public EmployeeRestController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping
  public List<Employee> findAll() {
    return employeeService.findAll();
  }

  @GetMapping("/{employeeId}")
  public Employee getEmployee(@PathVariable int employeeId) {
    Employee employee = employeeService.findById(employeeId);

    if (employee == null) {
      throw new RuntimeException("Employee id not found: " + employee);
    }

    return employee;
  }

  @PostMapping
  public Employee addEmployee(@RequestBody Employee employee) {
    employee.setId(0);
    employeeService.save(employee);
    return employee;
  }

  @PutMapping
  public Employee editEmployee(@RequestBody Employee employee) {
    employeeService.save(employee);
    return employee;
  }

  @DeleteMapping("/{employeeId}")
  public String deleteEmployee(@PathVariable int employeeId) {
    Employee employee = employeeService.findById(employeeId);

    if (employee == null) {
      throw new RuntimeException("Employee id not found: " + employee);
    }

    employeeService.deleteById(employeeId);
    return "Deleted employee id: " + employeeId;
  }

}
