package com.ines.demo.dao.impl;

import com.ines.demo.dao.IGenericDao;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@RequestScoped
public abstract class GenericDao<T extends Serializable, PK> implements IGenericDao<T, PK> {

	@PersistenceUnit(unitName= "persistence-demo")
	private EntityManagerFactory entityManagerFactory;
	protected EntityManager entityManager;
	public abstract Class<T> getEntityClass();
	
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
		this.entityManager = entityManagerFactory.createEntityManager();
	}
	
	@Override
	public T find(PK pk) {
		return entityManager.find(getEntityClass(), pk);
	}

	@Override
	public T update(T t) {
		entityManager.persist(t);
		entityManager.flush();
		return t;
	}

	@Override
	public void delete(T t) {
		entityManager.remove(t);
	}

	@Override
	public T add(T t) {
		entityManager.persist(t);
		entityManager.flush();
		return t;
	}

	@Override
	protected void finalize() throws Throwable {
		this.entityManager.close();
	}
	
}
