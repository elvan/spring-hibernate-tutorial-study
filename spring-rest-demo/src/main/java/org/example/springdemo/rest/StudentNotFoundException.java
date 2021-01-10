package org.example.springdemo.rest;

public class StudentNotFoundException extends RuntimeException {

  private static final long serialVersionUID = -5538251013700408091L;

  public StudentNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public StudentNotFoundException(String message) {
    super(message);
  }

  public StudentNotFoundException(Throwable cause) {
    super(cause);
  }

}
