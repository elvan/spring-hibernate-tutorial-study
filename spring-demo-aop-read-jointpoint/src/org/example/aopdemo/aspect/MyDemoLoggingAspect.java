package org.example.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
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

}
