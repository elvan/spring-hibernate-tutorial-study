package org.example.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// @ComponentScan("org.example.springdemo")
public class SportConfig {
  // define bean for our sad fortune service
  @Bean
  public FortuneService sadFortuneService() {
    return new SadFortuneService();
  }

  // define bean for our swim coach AND inject dependency
  @Bean
  public Coach swimCoach() {
    return new SwimCoach(sadFortuneService());
  }

}
