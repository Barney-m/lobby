package com.stx.centre.core.orm;

public interface IBaseORM<T, E> {
	T findByPrimaryKey(E primaryKey);
}
