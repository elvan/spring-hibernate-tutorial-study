package com.example.springboot.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

  @GetMapping("/")
  public String showHelloWorld() {
    return "Hello World! Time on server is " + LocalDateTime.now();
  }

}
