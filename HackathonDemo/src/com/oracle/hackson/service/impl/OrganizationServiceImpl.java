package com.oracle.hackson.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oracle.hackson.bean.Address;
import com.oracle.hackson.bean.Building;
import com.oracle.hackson.bean.Country;
import com.oracle.hackson.bean.Employee;
import com.oracle.hackson.bean.EmployeeResult;
import com.oracle.hackson.bean.JobTitle;
import com.oracle.hackson.bean.ManagerLevel;
import com.oracle.hackson.bean.Organization;
import com.oracle.hackson.dao.BasicDAO;
import com.oracle.hackson.service.EmployeeService;
import com.oracle.hackson.service.OrganizationService;

@Service("organizationService")
public class OrganizationServiceImpl implements OrganizationService{

	@Resource
	private BasicDAO<Organization> organizationDAO;

	@Override
	public Organization getOrganizationByID(int id) {
		// TODO Auto-generated method stub
		Organization org = organizationDAO.get(" from Organization org where org.orgID = ?", 
				new Object[] {id});
		return org;
	}

	@Override
	public List<Organization> getOrganizationBypID(int parent) {
		// TODO Auto-generated method stub
		List<Organization> list = organizationDAO.find(" from Organization org where org.parentOrgID = ?", 
				new Object[] {parent});
		return list;
	}


}
