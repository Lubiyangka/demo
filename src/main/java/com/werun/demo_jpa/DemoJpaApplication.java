package com.werun.demo_jpa;

import com.werun.demo_jpa.daomain.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoJpaApplication.class, args);
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("db");
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction=entityManager.getTransaction();
        entityTransaction.begin();
        User user=new User();
        entityManager.persist(user);
        entityTransaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

}
