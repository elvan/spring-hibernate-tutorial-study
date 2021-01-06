package org.example.aopdemo;

import org.example.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundDemoApp {

  public static void main(String[] args) {
    // read spring config java class
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
      DemoConfig.class
    );

    // get the bean from spring container
    TrafficFortuneService fortuneService = context.getBean(
      TrafficFortuneService.class
    );

    System.out.println("Main Program: AroundDemoApp");
    System.out.println("Calling getFortune()");

    String data = fortuneService.getFortune();

    System.out.println("My fortune is: " + data);
    System.out.println("Finished");

    // close the context
    context.close();
  }

}
