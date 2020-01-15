package ru.voskhod.hibernate.demo;

import ru.voskhod.hibernate.demo.entity.Course;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DeleteCourseDemo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence Unit");
        EntityManager entityManager = emf.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            // get a course
            int id = 10;
            Course course = entityManager.find(Course.class, id);

            // delete a course
            System.out.println("Deleting a course: " + course);

            entityManager.remove(course);

            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
            emf.close();
        }
    }
}
