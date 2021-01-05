package org.example.springdemo.controller;

import java.util.List;

import org.example.springdemo.entity.Customer;
import org.example.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

  @PostMapping("/saveCustomer")
  public String saveCustomer(@ModelAttribute("customer") Customer customer) {
    // save the customer using our service
    service.saveCustomer(customer);
    return "redirect:/customer/list";
  }

  @GetMapping("/showFormForUpdate")
  public String showFormForUpdate(
    @RequestParam("customerId") int id,
    Model model
  ) {
    // get the customer from the service
    Customer customer = service.getCustomer(id);

    // set customer as a model attribute to pre-populate the form
    model.addAttribute("customer", customer);

    // send over to our form
    return "customer-form";
  }

}
