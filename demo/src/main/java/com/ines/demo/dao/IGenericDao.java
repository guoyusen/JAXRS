package com.ines.demo.dao;

import java.io.Serializable;

public interface IGenericDao<T extends Serializable, PK> {

	T find(PK pk);
	
	T update(T t);
	
	void delete(T t);
	
	T add(T t);
	
}
