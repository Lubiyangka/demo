package com.werun.demo_jpa.controller.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaUtil {
    private static EntityManagerFactory entityManagerFactory;
    static {
        entityManagerFactory= Persistence.createEntityManagerFactory("db");
    }
    public static EntityManager getEntityManager(){
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        return entityManager;
    }
}
