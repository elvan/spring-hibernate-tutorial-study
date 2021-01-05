package org.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLogginAspect {
  // this is where we add all of our related advice for logging

  // let's start with an @Before advice
  @Before("execution(* org.example.aopdemo.repository.*.*(..))")
  public void beforeAddAccountAdvice() {
    System.out.println("Executing @Before advice on a method()");
  }

}
