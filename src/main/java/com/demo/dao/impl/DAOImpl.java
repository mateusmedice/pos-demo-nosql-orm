package com.demo.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.demo.dao.DAO;

public class DAOImpl <T, PK extends Serializable> implements DAO<T, PK> {

	private EntityManager entityManager;
	
	public DAOImpl() {
		
		if (this.entityManager == null) {
			this.entityManager = getEntityManager();
		}
		
	}
	
	public void persist(T t) {
		
		try {
			
			begin();
			
			this.entityManager.persist(t);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			commit();
		}
	}

	public T merge(T t) {

		try {
			
			begin();
			
			return this.entityManager.merge(t);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			commit();
		}
	}

	public T getById(Class clazz, PK pk) {

		try {
			
			begin();
			
			return (T) this.entityManager.find(clazz, pk);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			commit();
		}
	}

	public List<T> getAll() {
		return null;
	}

	public void remove(T t) {

		try {
			
			begin();
			
			this.entityManager.remove(t);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			commit();
		}
	}

	public void begin() {
		this.entityManager.getTransaction().begin();
	}

	public void commit() {
		this.entityManager.getTransaction().commit();
	}

	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("demonstracao-pu").createEntityManager();
	}

}
