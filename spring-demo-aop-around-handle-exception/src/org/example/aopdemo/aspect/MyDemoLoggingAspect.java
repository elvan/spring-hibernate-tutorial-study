package org.example.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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

  private static Logger logger = Logger.getLogger(
    MyDemoLoggingAspect.class.getName()
  );

  @Before(
    "org.example.aopdemo.aspect.ExampleAopExpressions.forRepositoryNoGetterSetter()"
  )
  public void beforeAddAccountAdvice(JoinPoint joinPoint) {
    logger.info(">> MyDemoLoggingAspect");

    // display the method signature
    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    logger.info("MethodSignature: " + signature);

    // display the method arguments

    // get args
    Object[] args = joinPoint.getArgs();

    // loop through args
    for (Object tempArg : args) {
      logger.info("Arg: " + tempArg);

      if (tempArg instanceof Account) {
        // downcast and print Account specific stuff
        Account account = (Account) tempArg;

        logger.info("account name: " + account.getName());
        logger.info("account level: " + account.getLevel());
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
    logger.info("Executing @AfterReturning on method: " + method);

    // print out the results of the method call
    logger.info("@AfterReturning result is: " + result);

    // let's post-process the data .. let's modify it

    // convert the account names to uppercase

    convertAccountNamesToUpperCase(result);

  }

  @AfterThrowing(
    pointcut = "execution(* org.example.aopdemo.repository.AccountRepository.findAccounts(..))",
    throwing = "exc"
  )
  public void afterThrowingFindAccountAdvice(
    JoinPoint joinPoint,
    Throwable exc
  ) {
    // print out which method we are advising on
    String method = joinPoint.getSignature().toShortString();
    logger.info("Executing @AfterThrowing on method: " + method);

    // log the exception
    logger.info("The exception is: " + exc);

  }

  @After(
    "execution(* org.example.aopdemo.repository.AccountRepository.findAccounts(..))"
  )
  public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
    // print out which method we are advising on
    String method = joinPoint.getSignature().toShortString();
    logger.info("Executing @After (finally) on method: " + method);
  }

  @Around(
    "execution(* org.example.aopdemo.service.*.getFortune(..))"
  )
  public Object aroundGetFortune(
    ProceedingJoinPoint theProceedingJoinPoint
  ) throws Throwable {
    // print out method we are advising on
    String method = theProceedingJoinPoint.getSignature().toShortString();
    logger.info("Executing @Around on method: " + method);

    // get begin timestamp
    long begin = System.currentTimeMillis();

    // execute the method
    Object result = theProceedingJoinPoint.proceed();

    // get and timestamp
    long end = System.currentTimeMillis();

    // compute duration and display it
    long duration = end - begin;
    logger.info("Duration: " + duration / 1000 + " seconds");

    return result;
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
