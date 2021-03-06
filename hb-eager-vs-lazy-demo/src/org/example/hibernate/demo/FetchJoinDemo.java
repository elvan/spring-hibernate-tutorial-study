package org.example.hibernate.demo;

import org.example.hibernate.demo.entity.Course;
import org.example.hibernate.demo.entity.Instructor;
import org.example.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {

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

      // option 2: Hibernate query with HQL

      Query<Instructor> query = session.createQuery(
        "select i from Instructor i " +
          "join fetch i.courses " +
          "where i.id=:theInstructorId",
        Instructor.class
      );

      // set parameter on query
      query.setParameter("theInstructorId", theId);

      // execute query and get instructor
      Instructor tempInstructor = query.getSingleResult();

      System.out.println("Example: Instructor: " + tempInstructor);

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
