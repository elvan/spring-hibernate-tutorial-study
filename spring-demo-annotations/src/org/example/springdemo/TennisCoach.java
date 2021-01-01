package org.example.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

  @Autowired
  @Qualifier("happyFortuneService")
  private FortuneService fortuneService;

  // @Autowired
  // public TennisCoach(FortuneService fortuneService) {
  // this.fortuneService = fortuneService;
  // }

  public TennisCoach() {
    System.out.println(">> TennisCoach: inside default constructor");
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
