package org.example.springdemo.repository;

import java.util.List;

import org.example.springdemo.entity.Customer;

// Data Access Object (DAO)
public interface CustomerRepository {

  public List<Customer> getCustomers();

}
