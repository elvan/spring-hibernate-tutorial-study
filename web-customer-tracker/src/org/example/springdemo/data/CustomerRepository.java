package org.example.springdemo.data;

import java.util.List;

import javax.transaction.Transactional;

import org.example.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository implements CustomerDAO {

  // need to inject the session factory
  @Autowired
  private SessionFactory sessionFactory;

  @Override
  @Transactional
  public List<Customer> getCustomers() {
    // get the current hibernate session
    Session session = sessionFactory.getCurrentSession();

    // create a query
    Query<Customer> query = session.createQuery(
      "from Customer",
      Customer.class
    );

    // execute query and get result list
    List<Customer> customers = query.getResultList();

    // return the results
    return customers;
  }

}
