package org.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
  // this is where we add all of our related advice for logging

  // let's start with an @Before advice

  @Pointcut("execution(* org.example.aopdemo.repository.*.*(..))")
  private void forRepositoryPackage() {
  }

  // create pointcut for getter methods
  @Pointcut("execution(* org.example.aopdemo.repository.*.get*(..))")
  private void forGetterMethods() {
  }

  // create pointcut for setter methods
  @Pointcut("execution(* org.example.aopdemo.repository.*.set*(..))")
  private void forSetterMethods() {
  }

  // create pointcut include package .. exclude getter/setter
  @Pointcut(
    "forRepositoryPackage() && !(forGetterMethods() || forSetterMethods())"
  )
  public void forRepositoryNoGetterSetter() {
  }

  @Before("forRepositoryNoGetterSetter()")
  public void beforeAddAccountAdvice() {
    System.out.println("Executing @Before advice on method()");
  }

  @Before("forRepositoryNoGetterSetter()")
  public void performApiAnalytics() {
    System.out.println("Performing API analytics");
  }

}
