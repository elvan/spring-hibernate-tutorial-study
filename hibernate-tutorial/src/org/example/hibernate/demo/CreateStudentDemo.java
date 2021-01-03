package org.example.hibernate.demo;

import org.example.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

  public static void main(String[] args) {
    // create session factory
    SessionFactory factory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(Student.class)
      .buildSessionFactory();

    // create a session
    Session session = factory.getCurrentSession();

    try {
      // create a student object
      System.out.println("Creating new student object");
      Student tempStudent = new Student("Aaron", "Blake", "paul@example.org");

      // start a transaction
      session.beginTransaction();

      // save the student object
      System.out.println("Saving the student");
      session.save(tempStudent);

      // commit transaction
      session.getTransaction().commit();
    }
    finally {
      factory.close();
    }

  }

}
