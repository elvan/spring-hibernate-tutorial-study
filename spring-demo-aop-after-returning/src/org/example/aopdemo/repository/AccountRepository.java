package org.example.aopdemo.repository;

import java.util.ArrayList;
import java.util.List;

import org.example.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountRepository {

  private String name;

  private String serviceCode;

  // add new method findAccounts()

  public List<Account> findAccounts() {
    List<Account> accounts = new ArrayList<>();

    // create sample accounts
    Account temp1 = new Account("Aaron", "Silver");
    Account temp2 = new Account("Noah", "Platinum");
    Account temp3 = new Account("Blake", "Gold");

    // add them to the accounts list
    accounts.add(temp1);
    accounts.add(temp2);
    accounts.add(temp3);

    return accounts;
  }

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
