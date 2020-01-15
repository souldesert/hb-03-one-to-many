package ru.voskhod.hibernate.demo;

import ru.voskhod.hibernate.demo.entity.Instructor;
import ru.voskhod.hibernate.demo.entity.InstructorDetail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreateInstructorDemo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence Unit");
        EntityManager entityManager = emf.createEntityManager();

        try {
            Instructor instructor = new Instructor("Susan", "Public", "susan@luv2code.com");

            InstructorDetail instructorDetail =
                    new InstructorDetail("http://www.youtube.com", "Video Games");

            instructor.setInstructorDetail(instructorDetail);

            entityManager.getTransaction().begin();

            entityManager.persist(instructor);

            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
            emf.close();
        }
    }
}
