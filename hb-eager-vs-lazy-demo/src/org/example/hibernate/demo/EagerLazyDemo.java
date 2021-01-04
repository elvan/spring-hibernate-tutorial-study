package org.example.hibernate.demo;

import org.example.hibernate.demo.entity.Course;
import org.example.hibernate.demo.entity.Instructor;
import org.example.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {

  public static void main(String[] args) {
    // create session factory
    SessionFactory factory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(Instructor.class)
      .addAnnotatedClass(InstructorDetail.class)
      .addAnnotatedClass(Course.class)
      .buildSessionFactory();

    // create a session
    Session session = factory.getCurrentSession();

    try {
      // start a transaction
      session.beginTransaction();

      // get the instructor from db
      int theId = 1;
      Instructor tempInstructor = session.get(Instructor.class, theId);

      System.out.println("Example: Instructor: " + tempInstructor);

      // option 1: call getter method while session is open
      System.out.println("Example: Courses: " + tempInstructor.getCourses());

      // commit transaction
      session.getTransaction().commit();

      // close the session
      session.close();

      System.out.println("Example: The session is now closed");

      // get courses for the instructor
      System.out.println("Example: Courses: " + tempInstructor.getCourses());

      System.out.println("Example: Done!");
    }
    finally {
      // add clean up code
      session.close();

      factory.close();
    }
  }

}
