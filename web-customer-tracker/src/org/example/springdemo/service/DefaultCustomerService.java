package org.example.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.example.springdemo.entity.Customer;
import org.example.springdemo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultCustomerService implements CustomerService {

  // need to inject customer repository
  @Autowired
  private CustomerRepository repository;

  @Override
  @Transactional
  public List<Customer> getCustomers() {
    return repository.getCustomers();
  }

  @Override
  @Transactional
  public void saveCustomer(Customer customer) {
    repository.saveCustomer(customer);
  }

}
