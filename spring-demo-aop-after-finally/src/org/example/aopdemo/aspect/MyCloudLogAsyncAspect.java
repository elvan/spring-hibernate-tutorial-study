package org.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {

  @Before(
    "org.example.aopdemo.aspect.ExampleAopExpressions.forRepositoryNoGetterSetter()"
  )
  public void logToCloudAsync() {
    System.out.println(">> MyCloudLogAsyncAspect");
  }

}
