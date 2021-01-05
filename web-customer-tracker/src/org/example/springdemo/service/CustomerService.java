package org.example.springdemo.service;

import java.util.List;

import org.example.springdemo.entity.Customer;

public interface CustomerService {

  public List<Customer> getCustomers();

  public void saveCustomer(Customer customer);

  public Customer getCustomer(int id);

}
