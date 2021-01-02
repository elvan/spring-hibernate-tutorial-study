package org.example.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

  // need a controller method to show the initial HTML form
  @RequestMapping("/showForm")
  public String showForm() {
    return "hello-world-form";
  }

  // need a controller method to process the HTML form
  public String processForm() {
    return "hello-world-form";
  }

}
