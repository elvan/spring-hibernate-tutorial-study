package org.example.aopdemo.repository;

import org.springframework.stereotype.Component;

@Component
public class AccountRepository {

  public void addAccount() {
    System.out.println(getClass() + ": Doing my DB work: Adding an Account");
  }

}
