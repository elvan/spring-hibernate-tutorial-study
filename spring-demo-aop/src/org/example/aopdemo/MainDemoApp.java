package org.example.aopdemo;

import org.example.aopdemo.repository.AccountRepository;
import org.example.aopdemo.repository.MembershipRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

  public static void main(String[] args) {
    // read spring config java class
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
      DemoConfig.class
    );

    // get the bean from spring container
    AccountRepository accountRepository = context.getBean(
      AccountRepository.class
    );

    // get membership bean from spring container
    MembershipRepository membershipRepository = context.getBean(
      MembershipRepository.class
    );

    // call the business method
    accountRepository.addAccount();

    // call the membership business method
    membershipRepository.addAccount();

    // do it again
    System.out.println("Let's call it again!");

    // call the business method again
    accountRepository.addAccount();

    // close the context
    context.close();
  }

}
