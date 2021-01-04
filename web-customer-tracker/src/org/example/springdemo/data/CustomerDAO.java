package org.example.springdemo.data;

import java.util.List;

import org.example.springdemo.entity.Customer;

public interface CustomerDAO {

  public List<Customer> getCustomers();

}
