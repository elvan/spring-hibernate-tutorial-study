package org.example.springdemo.controller;

import java.util.List;

import org.example.springdemo.data.CustomerData;
import org.example.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

  // need to inject the customer DAO
  @Autowired
  private CustomerData customerData;

  @GetMapping("/list")
  public String listCustomers(Model model) {
    // get customers from the DAO
    List<Customer> customers = customerData.getCustomers();

    // add the customers to the model
    model.addAttribute("customers", customers);

    return "list-customers";
  }

}
