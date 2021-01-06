package org.example.aopdemo;

import java.util.List;

import org.example.aopdemo.repository.AccountRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AfterFinallyDemoApp {

  public static void main(String[] args) {
    // read spring config java class
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
      DemoConfig.class
    );

    // get the bean from spring container
    AccountRepository accountRepository = context.getBean(
      AccountRepository.class
    );

    // call method to find the accounts
    List<Account> accounts = null;

    try {
      // add a boolean flag tu simulate exceptions
      boolean tripWire = false;
      accounts = accountRepository.findAccounts(tripWire);
    }
    catch (Exception exc) {
      System.out.println("Main Program .. caught exception: " + exc);
    }

    // display the accounts
    System.out.println("Main Program: AfterThrowingDemoApp");
    System.out.println(accounts);

    // close the context
    context.close();
  }

}
