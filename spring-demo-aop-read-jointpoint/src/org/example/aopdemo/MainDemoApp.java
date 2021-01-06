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
    Account account = new Account();
    account.setName("Aaron");
    account.setLevel("Platinum");
    accountRepository.addAccount(account, true);
    accountRepository.doWork();

    // call the account getters/setters
    accountRepository.setName("foobar");
    accountRepository.setServiceCode("silver");

    String name = accountRepository.getName();
    String code = accountRepository.getServiceCode();

    // call the membership business method
    membershipRepository.addSillyMember();
    membershipRepository.goToSleep();

    // close the context
    context.close();
  }

}
