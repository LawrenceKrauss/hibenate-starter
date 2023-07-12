package org.example;

import org.example.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        Configuration configuration = new Configuration();

        configuration.configure();
        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            User user = User.builder()
                    .username("vanya@gmail.ru")
                    .firstname("Ivan")
                    .lastname("Petrov")
                    .birthDate(LocalDate.of(1999,1,20))
                    .age(24)
                    .build();
            session.persist(user);

            session.getTransaction().commit();
        }
    }
}