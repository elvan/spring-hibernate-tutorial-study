package org.example.hibernate.demo;

import org.example.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

  public static void main(String[] args) {
    // create session factory
    SessionFactory factory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(Student.class)
      .buildSessionFactory();

    // create a session
    Session session = factory.getCurrentSession();

    try {
      // create 3 student objects
      System.out.println("Creating 3 student objects");
      Student tempStudent1 = new Student(
        "Liam",
        "Noah",
        "liam@example.org"
      );
      Student tempStudent2 = new Student(
        "Oliver",
        "William",
        "oliver@example.org"
      );
      Student tempStudent3 = new Student(
        "Elijah",
        "James",
        "elijah@example.org"
      );

      // start a transaction
      session.beginTransaction();

      // save the student object
      System.out.println("Saving the student");
      session.save(tempStudent1);
      session.save(tempStudent2);
      session.save(tempStudent3);

      // commit transaction
      session.getTransaction().commit();
    }
    finally {
      factory.close();
    }
  }

}
