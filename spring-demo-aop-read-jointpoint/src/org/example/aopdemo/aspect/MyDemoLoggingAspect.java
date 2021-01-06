package org.example.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
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

  }

}
