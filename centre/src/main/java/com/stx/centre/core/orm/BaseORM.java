package com.stx.centre.core.orm;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BaseORM<T, E> implements IBaseORM<T, E> {

	@PersistenceContext
	private EntityManager em;
	
	protected Class<T> clazz;
	
	public BaseORM() {
		this.getClassObject();
	}

    protected void getClassObject() {
        this.clazz = null;
    }
	
	public T findByPrimaryKey(E primaryKey) {
		return em.find(clazz, primaryKey);
	}
}
