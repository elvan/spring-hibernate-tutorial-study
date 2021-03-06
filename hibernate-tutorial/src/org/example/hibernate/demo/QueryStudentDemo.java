package org.example.hibernate.demo;

import java.util.List;

import org.example.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryStudentDemo {

  public static void main(String[] args) {
    // create session factory
    SessionFactory factory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(Student.class)
      .buildSessionFactory();

    // create a session
    Session session = factory.getCurrentSession();

    try {
      // start a transaction
      session.beginTransaction();

      // query students
      List<Student> theStudents = session.createQuery("from Student")
        .getResultList();

      // display the students
      displayStudents(theStudents);

      // query students: lastName='James'
      theStudents = session.createQuery(
        "from Student s where s.lastName='James'"
      ).getResultList();

      // display the students
      System.out.println("Students who have last name of James");
      displayStudents(theStudents);

      // query students: lastName='James' OR firstName='Liam'
      theStudents = session.createQuery(
        "from Student s where " +
          "s.lastName='James' OR " +
          "s.firstName='Liam'"
      ).getResultList();

      System.out.println(
        "Students who have last name of James OR first name of Liam"
      );
      displayStudents(theStudents);

      // query students where email LIKE '%gmail.com'
      theStudents = session.createQuery(
        "from Student s where s.email LIKE '%gmail.com'"
      ).getResultList();

      System.out.println("Students whose have email ends with gmail.com'");
      displayStudents(theStudents);

      // commit transaction
      session.getTransaction().commit();

      System.out.println("Done!");
    }
    finally {
      factory.close();
    }
  }

  private static void displayStudents(List<Student> theStudents) {
    for (Student tempStudent : theStudents) {
      System.out.println(tempStudent);
    }
  }

}
