package com.example.springdemo.repository;

import java.util.List;

import com.example.springdemo.entity.Customer;

public interface CustomerRepository {

  public List<Customer> getCustomers();

  public void saveCustomer(Customer theCustomer);

  public Customer getCustomer(int theId);

  public void deleteCustomer(int theId);

}
