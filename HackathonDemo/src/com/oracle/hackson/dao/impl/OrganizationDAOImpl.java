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

import com.oracle.hackson.bean.Employee;
import com.oracle.hackson.dao.BasicDAO;

@Repository("organizationDAO")
@SuppressWarnings("all")
public class OrganizationDAOImpl  extends BasicDAOImpl<Employee> {

}
