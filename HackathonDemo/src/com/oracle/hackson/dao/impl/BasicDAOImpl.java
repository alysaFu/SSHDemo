package com.oracle.hackson.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oracle.hackson.dao.BasicDAO;

@Repository("basicDAO")
public class BasicDAOImpl<T>  implements BasicDAO<T> {

	private Logger logger = Logger.getLogger(BasicDAOImpl.class);
	private SessionFactory sessionFactory;
	
	protected SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	@Autowired
	protected void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
		logger.debug("SessionFactory Autowired");
	}
	
	/*
	 * get current session
	 */
	protected Session getCurrentSession(){
		return this.sessionFactory.getCurrentSession();
	}
	

	public Serializable save(T t) {
		// TODO Auto-generated method stub
		return this.getCurrentSession().save(t);
	}

	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		this.getCurrentSession().update(t);
	}

	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		this.getCurrentSession().delete(t);
	}

    public List<T> find(String hql) {  
    	return find(hql, null);
    } 
    
	@Override
	public List<T> find(String hql, Object[] params) {
		// TODO Auto-generated method stub 
		Query query = this.getCurrentSession().createQuery(hql);
	    if(params!= null && params.length > 0){
	    	for(int i = 0; i < params.length; ++i){
	    		query.setParameter(i, params[i]);
	    	}
	    }
	    List<T> list = query.list();
	    if(list == null || list.size() == 0)
	    	return null;
	    else
	    	return list;
	}

	@Override
	public T get(Class<T> clazz, Serializable id) {
		// TODO Auto-generated method stub
		return (T) this.getCurrentSession().get(clazz, id);
	}

	@Override
	public T get(String hql, Object[] params) {
		// TODO Auto-generated method stub
		List<T> list = find(hql, params);
		if(list != null && list.size() > 0)
			return list.get(0);
		else
			return null;
	}

}
