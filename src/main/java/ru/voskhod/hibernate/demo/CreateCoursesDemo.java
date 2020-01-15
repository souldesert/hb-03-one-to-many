package ru.voskhod.hibernate.demo;

import ru.voskhod.hibernate.demo.entity.Course;
import ru.voskhod.hibernate.demo.entity.Instructor;
import ru.voskhod.hibernate.demo.entity.InstructorDetail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreateCoursesDemo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence Unit");
        EntityManager entityManager = emf.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            // get the instructor from db

            int id = 1;
            Instructor instructor = entityManager.find(Instructor.class, id);

            // create some courses

            Course courseOne = new Course("Air Guitar - The Ultimate Guide");
            Course courseTwo = new Course("The Pinball Masterclass");

            // add courses to instructor

            instructor.add(courseOne);
            instructor.add(courseTwo);

            // save the courses

            entityManager.persist(courseOne);
            entityManager.persist(courseTwo);

            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
            emf.close();
        }
    }
}
