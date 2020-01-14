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

        // create and save Student object to MySQL database
        try (factory) {
            Session session = factory.getCurrentSession();

            // start a transaction
            session.beginTransaction();

            // get instructor by id
            int id = 1;

            Instructor instructor = session.get(Instructor.class, id);

            System.out.println("Found instructor: " + instructor);

            // delete instructor
            if (instructor != null) {
                System.out.println("Deleting instructor: " + instructor);

                // this will delete instructor as well as corresponding
                // instructor details
                session.delete(instructor);
            }

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        }
    }
}
