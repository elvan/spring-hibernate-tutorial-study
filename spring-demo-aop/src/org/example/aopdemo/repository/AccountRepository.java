package org.example.aopdemo.repository;

import org.example.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountRepository {

  public void addAccount(Account account, boolean vipFlag) {
    System.out.println(getClass() + ": Doing my DB work: Adding an Account");
  }

  public boolean doWork() {
    System.out.println(getClass() + ": Doing doWork() method");
    return false;
  }

}
