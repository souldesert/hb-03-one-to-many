package ru.voskhod.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.voskhod.hibernate.demo.entity.Instructor;
import ru.voskhod.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        // create and save Student object to MySQL database
        try (factory; session) {

            // start a transaction
            session.beginTransaction();

            // get the instructor detail object
            int id = 2;

            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);

            // print instructor details
            System.out.println("Fetched instructor details: " + instructorDetail);

            // print associated instructor
            System.out.println("The associated instructor: " + instructorDetail.getInstructor());

            session.getTransaction().commit();

            System.out.println("Done!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
