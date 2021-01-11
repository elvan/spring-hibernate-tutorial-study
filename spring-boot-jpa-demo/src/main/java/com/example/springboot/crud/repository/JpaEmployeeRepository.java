package com.example.springboot.crud.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springboot.crud.entity.Employee;

@Repository
public class JpaEmployeeRepository implements EmployeeRepository {

  private EntityManager entityManager;

  @Autowired
  public JpaEmployeeRepository(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public List<Employee> findAll() {
    TypedQuery<Employee> query = entityManager.createQuery(
      "from Employee",
      Employee.class
    );
    List<Employee> employees = query.getResultList();

    return employees;
  }

  @Override
  public Employee findById(int id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void save(Employee employee) {
    // TODO Auto-generated method stub

  }

  @Override
  public void deleteById(int id) {
    // TODO Auto-generated method stub

  }

}
