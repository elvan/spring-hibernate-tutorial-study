package org.example.aopdemo;

import java.util.logging.Logger;

import org.example.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundWithLoggerDemoApp {

  private static Logger logger = Logger.getLogger(
    AroundWithLoggerDemoApp.class.getName()
  );

  public static void main(String[] args) {
    // read spring config java class
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
      DemoConfig.class
    );

    // get the bean from spring container
    TrafficFortuneService fortuneService = context.getBean(
      TrafficFortuneService.class
    );

    logger.info("Main Program: AroundDemoApp");
    logger.info("Calling getFortune()");

    String data = fortuneService.getFortune();

    logger.info("My fortune is: " + data);
    logger.info("Finished");

    // close the context
    context.close();
  }

}
