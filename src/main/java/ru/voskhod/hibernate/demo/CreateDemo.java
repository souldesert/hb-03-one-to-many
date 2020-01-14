package ru.voskhod.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.voskhod.hibernate.demo.entity.Instructor;
import ru.voskhod.hibernate.demo.entity.InstructorDetail;

import java.text.ParseException;

public class CreateDemo {
    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // create session

        // create and save Student object to MySQL database
        try (factory) {
            Session session = factory.getCurrentSession();

            // create the objects

            Instructor instructor = new Instructor(
                    "Madhu",
                    "Patel",
                    "madhu@luv2code.com"
            );

            InstructorDetail instructorDetail = new InstructorDetail(
                    "http://www.youtube.com",
                    "Guitar"
            );

//            Instructor instructor = new Instructor(
//                    "Chad",
//                    "Darby",
//                    "darby@luv2code.com"
//            );
//
//            InstructorDetail instructorDetail = new InstructorDetail(
//                    "http://www.luv2code.com/youtube",
//                    "luv 2 code!!!"
//            );

            // associate objects
            instructor.setInstructorDetail(instructorDetail);

            // start a transaction
            session.beginTransaction();

            // save the instructor AND instructorDetail
            System.out.println("Saving instructor: " + instructor);
            session.save(instructor);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        }
    }
}
