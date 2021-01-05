package org.example.aopdemo.repository;

import org.example.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountRepository {

  private String name;

  private String serviceCode;

  public void addAccount(Account account, boolean vipFlag) {
    System.out.println(getClass() + ": Adding an Account");
  }

  public boolean doWork() {
    System.out.println(getClass() + ": doWork()");
    return false;
  }

  public String getName() {
    System.out.println(getClass() + ": getName()");
    return name;
  }

  public void setName(String name) {
    System.out.println(getClass() + ": setName()");
    this.name = name;
  }

  public String getServiceCode() {
    System.out.println(getClass() + ": getServiceCode()");
    return serviceCode;
  }

  public void setServiceCode(String serviceCode) {
    System.out.println(getClass() + ": setServiceCode()");
    this.serviceCode = serviceCode;
  }

}
