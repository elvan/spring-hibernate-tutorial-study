package org.example.aopdemo;

import org.example.aopdemo.repository.AccountRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

  public static void main(String[] args) {
    // read spring config java class
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
      DemoConfig.class
    );

    // get the bean from spring container
    AccountRepository repository = context.getBean(AccountRepository.class);

    // call the business method
    repository.addAccount();

    // do it again
    System.out.println("Let's call it again!");

    // call the business method again
    repository.addAccount();

    // close the context
    context.close();
  }

}
