package org.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLogginAspect {
  // this is where we add all of our related advice for logging

  // let's start with an @Before advice

  @Pointcut("execution(* org.example.aopdemo.repository.*.*(..))")
  private void forRepositoryPackage() {
  }

  @Before("forRepositoryPackage()")
  public void beforeAddAccountAdvice() {
    System.out.println("Executing @Before advice on a method()");
  }

  @Before("forRepositoryPackage()")
  public void performApiAnalytics() {
    System.out.println("Performing API analytics");
  }

}
