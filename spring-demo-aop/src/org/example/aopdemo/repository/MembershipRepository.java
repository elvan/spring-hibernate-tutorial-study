package org.example.aopdemo.repository;

import org.springframework.stereotype.Component;

@Component
public class MembershipRepository {

  public boolean addSillyMember() {
    System.out.println(
      getClass() + ": Doing Stuff: Adding a Membership Account"
    );
    return true;
  }

  public void goToSleep() {
    System.out.println(
      getClass() + ": I'm going to sleep now ..."
    );
  }

}
