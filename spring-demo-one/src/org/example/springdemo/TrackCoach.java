package org.example.springdemo;

public class TrackCoach implements Coach {

  private FortuneService fortuneService;

  public TrackCoach() {
  }

  public TrackCoach(FortuneService fortuneService) {
    this.fortuneService = fortuneService;
  }

  @Override
  public String getDailyWorkout() {
    return "Run a hard 5K";
  }

  @Override
  public String getDailyFortune() {
    return "Just Do It: " + fortuneService.getFortune();
  }

  // add an init method
  public void doMyStartupStuff() {
    System.out.println("TrackCoach: inside method doMyStartupStuff");
  }

  // ad a destroy method
  public void doMyCleanupStuff() {
    System.out.println("TrackCoach: inside method doMyCleanupStuff");
  }

}
