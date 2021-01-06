package org.example.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

  public String getFortune() {
    // simulate a delay
    try {
      TimeUnit.SECONDS.sleep(5);
    }
    catch (InterruptedException exc) {
      exc.printStackTrace();
    }

    // return a fortune
    return "Expect heavy traffics this morning";
  }

}
