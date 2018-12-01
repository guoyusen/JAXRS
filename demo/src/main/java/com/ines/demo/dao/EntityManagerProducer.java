package com.ines.demo.dao;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProducer {

	@RequestScoped
    @Produces
    EntityManager createEntityManager() {
    	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-demo");
        return entityManagerFactory.createEntityManager();
    }
}