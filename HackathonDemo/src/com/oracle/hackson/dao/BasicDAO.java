package com.oracle.hackson.dao;

import java.io.Serializable;
import java.util.List;

public interface BasicDAO<T> {
	
	public Serializable save(T t);
	
	public void update(T t);
	
	public void delete(T t);
	
	public T get(Class<T> clazz, Serializable id);
	
	public List<T> find(String hql);
	
	public List<T> find(String hql, Object[] params);
	
	public T get(String hql, Object[] params);

}
