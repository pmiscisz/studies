package com.example.demo;

import com.example.demo.factory.HibernateFactory;
import com.example.demo.models.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestApp {
    public static void main(String[] args) {
        Session session = HibernateFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Student student = new Student();
        student.setName("Jan");
        student.setSurname("Kowalski");
        student.setAverageGrade(4.5);

        session.persist(student);
        tx.commit();

        session.close();
        HibernateFactory.getSessionFactory().close();

        System.out.println(" tudent zapisany do bazy!");
    }
}
