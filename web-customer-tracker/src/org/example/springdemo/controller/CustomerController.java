package org.example.springdemo.controller;

import java.util.List;

import org.example.springdemo.entity.Customer;
import org.example.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

  // need to inject the customer service
  @Autowired
  private CustomerService service;

  @GetMapping("/list")
  public String listCustomers(Model model) {
    // get customers from the service
    List<Customer> customers = service.getCustomers();

    // add the customers to the model
    model.addAttribute("customers", customers);

    return "list-customers";
  }

  @GetMapping("/showFormForAdd")
  public String showFormForAdd(Model model) {
    // create model attribute to bind form data
    Customer customer = new Customer();
    model.addAttribute("customer", customer);

    return "customer-form";
  }

}
