package org.example.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

  @Autowired
  @Qualifier("randomFortuneService")
  private FortuneService fortuneService;

  // @Autowired
  // public TennisCoach(FortuneService fortuneService) {
  // this.fortuneService = fortuneService;
  // }

  public TennisCoach() {
    System.out.println(">> TennisCoach: inside default constructor");
  }

  // define my init method
  @PostConstruct
  public void doMyStartupStuff() {
    System.out.println(">> TennisCoach: inside doMyStartupStuff");
  }

  // define my destroy method
  @PreDestroy
  public void doMyCleanupStuff() {
    System.out.println(">> TennisCoach: inside doMyCleanupStuff");
  }

  // @Autowired
  // public void doSomeCrazyStuf(FortuneService theFortuneService) {
  // System.out.println(">> TennisCouch: inside doSomeCrazyStuf");
  // fortuneService = theFortuneService;
  // }

  @Override
  public String getDailyWorkout() {
    return "Practice your backhand volley";
  }

  @Override
  public String getDailyFortune() {
    return fortuneService.getFortune();
  }

}
