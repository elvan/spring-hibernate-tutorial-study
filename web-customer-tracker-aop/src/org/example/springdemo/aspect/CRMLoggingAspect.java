package org.example.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

  // setup logger
  private Logger logger = Logger.getLogger(getClass().getName());

  // setup pointcut declarations

  @Pointcut("execution(* org.example.springdemo.controller.*.*(..))")
  private void forControllerPackage() {
  }

  @Pointcut("execution(* org.example.springdemo.service.*.*(..))")
  private void forServicePackage() {
  }

  @Pointcut("execution(* org.example.springdemo.repository.*.*(..))")
  private void forRespositoryPackage() {
  }

  // combine the declarations
  @Pointcut(
    "forControllerPackage() || forServicePackage() || forRespositoryPackage()"
  )
  private void forAppFlow() {
  }

  // add @Before advice

  @Before("forAppFlow()")
  public void before(JoinPoint joinPoint) {
    // display method we are calling
    String method = joinPoint.getSignature().toShortString();
    logger.info(">> @Before: calling method: " + method);

    // display the argument to the method
  }

  // add @AfterReturning advice

}
