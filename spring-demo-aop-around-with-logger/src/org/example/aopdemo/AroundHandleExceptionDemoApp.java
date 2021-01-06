package org.example.aopdemo;

import java.util.logging.Logger;

import org.example.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundHandleExceptionDemoApp {

  private static Logger logger = Logger.getLogger(
    AroundHandleExceptionDemoApp.class.getName()
  );

  public static void main(String[] args) {
    // read spring configuration java class
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
      DemoConfig.class
    );

    // get the bean from spring container
    TrafficFortuneService fortuneService = context.getBean(
      TrafficFortuneService.class
    );

    logger.info("Main Program: AroundHandleExceptionDemoApp");
    logger.info("Calling getFortune()");

    boolean tripWire = true;
    String data = fortuneService.getFortune(tripWire);

    logger.info("My fortune is: " + data);
    logger.info("Finished");

    // close the context
    context.close();
  }

}
