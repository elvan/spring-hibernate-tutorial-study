package org.example.springdemo.data;

import java.util.List;

import org.example.springdemo.entity.Customer;

// Data Access Object (DAO)
public interface CustomerData {

  public List<Customer> getCustomers();

}
