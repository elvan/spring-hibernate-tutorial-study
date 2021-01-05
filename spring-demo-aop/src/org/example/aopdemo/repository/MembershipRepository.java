package org.example.aopdemo.repository;

import org.springframework.stereotype.Component;

@Component
public class MembershipRepository {

  public void addSillyMember() {
    System.out.println(
      getClass() + ": Doing Stuff: Adding a Membership Account"
    );
  }

}
