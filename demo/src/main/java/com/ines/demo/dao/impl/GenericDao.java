package com.ines.demo.dao.impl;

import com.ines.demo.dao.IGenericDao;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@RequestScoped
public abstract class GenericDao<T extends Serializable, PK> implements IGenericDao<T, PK> {

	@Inject
	protected EntityManager entityManager;
	public abstract Class<T> getEntityClass();
	
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

	
	
}
