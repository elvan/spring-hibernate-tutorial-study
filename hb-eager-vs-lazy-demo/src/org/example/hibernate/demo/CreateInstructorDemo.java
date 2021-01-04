package org.example.hibernate.demo;

import org.example.hibernate.demo.entity.Course;
import org.example.hibernate.demo.entity.Instructor;
import org.example.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

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
      // create the objects
      Instructor tempInstructor1 = new Instructor(
        "Jeremy",
        "Williams",
        "jeremy@gmail.com"
      );
      InstructorDetail tempInstructorDetail1 = new InstructorDetail(
        "http://www.youtube.com/JeremyWilliams",
        "Blogging"
      );

      Instructor tempInstructor2 = new Instructor(
        "Paul",
        "John",
        "paul@gmail.com"
      );
      InstructorDetail tempInstructorDetail2 = new InstructorDetail(
        "http://www.youtube.com/PaulJohn",
        "Guitar"
      );

      // associate the objects
      tempInstructor1.setInstructorDetail(tempInstructorDetail1);
      tempInstructor2.setInstructorDetail(tempInstructorDetail2);

      // start a transaction
      session.beginTransaction();

      // save the instructor
      //
      // Note: this will ALSO save the details object
      // because of CascadeType.ALL
      //
      System.out.println("Saving instructor: " + tempInstructor1);
      session.save(tempInstructor1);

      System.out.println("Saving instructor: " + tempInstructor2);
      session.save(tempInstructor2);

      // commit transaction
      session.getTransaction().commit();
    }
    finally {
      // add clean up code
      session.close();

      factory.close();
    }
  }

}
