package com.example.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

  @ExceptionHandler
  public ResponseEntity<CustomerErrorResponse> handleException(
    CustomerNotFoundException exc
  ) {
    CustomerErrorResponse error = new CustomerErrorResponse(
      HttpStatus.NOT_FOUND.value(),
      exc.getMessage(),
      System.currentTimeMillis()
    );

    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }

}
