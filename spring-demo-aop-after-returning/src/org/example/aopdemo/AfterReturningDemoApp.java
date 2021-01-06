package org.example.aopdemo;

import java.util.List;

import org.example.aopdemo.repository.AccountRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AfterReturningDemoApp {

  public static void main(String[] args) {
    // read spring config java class
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
      DemoConfig.class
    );

    // get the bean from spring container
    AccountRepository accountRepository = context.getBean(
      AccountRepository.class
    );

    List<Account> accounts = accountRepository.findAccounts();

    // display the accounts
    System.out.println("Main Program: AfterReturningDemoApp");
    System.out.println(accounts);

    // close the context
    context.close();
  }

}
