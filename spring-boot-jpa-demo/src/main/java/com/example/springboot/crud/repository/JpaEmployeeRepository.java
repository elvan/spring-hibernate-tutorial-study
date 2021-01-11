package com.example.springboot.crud.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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
    Employee employee = entityManager.find(Employee.class, id);

    return employee;
  }

  @Override
  public void save(Employee employee) {
    Employee savedEmployee = entityManager.merge(employee);
    employee.setId(savedEmployee.getId());
  }

  @Override
  public void deleteById(int id) {
    Query query = entityManager.createQuery(
      "delete from Employee where id=:employeeId"
    );
    query.setParameter("employeeId", id);
    query.executeUpdate();
  }

}
