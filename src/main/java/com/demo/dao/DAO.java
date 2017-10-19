package com.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

public interface DAO <T, PK> {

	void persist(T t);
	
	T merge(T t);
	
	T getById(Class clazz, PK pk);
	
	List<T> getAll();
	
	void remove(T t);
	
	EntityManager getEntityManager();
	
	void begin();
	
	void commit();
	
}
