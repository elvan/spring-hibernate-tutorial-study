package org.example.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.example.aopdemo.Account;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

  @Before(
    "org.example.aopdemo.aspect.ExampleAopExpressions.forRepositoryNoGetterSetter()"
  )
  public void beforeAddAccountAdvice(JoinPoint joinPoint) {
    System.out.println(">> MyDemoLoggingAspect");

    // display the method signature
    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    System.out.println("MethodSignature: " + signature);

    // display the method arguments

    // get args
    Object[] args = joinPoint.getArgs();

    // loop through args
    for (Object tempArg : args) {
      System.out.println("Arg: " + tempArg);

      if (tempArg instanceof Account) {
        // downcast and print Account specific stuff
        Account account = (Account) tempArg;

        System.out.println("account name: " + account.getName());
        System.out.println("account level: " + account.getLevel());
      }
    }

  }

  @AfterReturning(
    pointcut = "execution(* org.example.aopdemo.repository.AccountRepository.findAccounts(..))",
    returning = "result"
  )
  public void afterReturningFindAccountsAdvice(
    JoinPoint joinPoint,
    List<Account> result
  ) {
    // print out which method we are advising on
    String method = joinPoint.getSignature().toShortString();
    System.out.println("Executing @AfterReturning on method: " + method);

    // print out the results of the method call
    System.out.println("@AfterReturning result is: " + result);

    // let's post-process the data .. let's modify it

    // convert the account names to uppercase

    convertAccountNamesToUpperCase(result);

  }

  private void convertAccountNamesToUpperCase(List<Account> result) {
    // loop throught accounts
    for (Account account : result) {
      // get uppercase version of name
      String upperName = account.getName().toUpperCase();

      // update the name on the account
      account.setName(upperName);
    }
  }

}
