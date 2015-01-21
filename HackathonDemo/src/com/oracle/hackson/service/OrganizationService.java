package com.oracle.hackson.service;

import java.util.List;

import com.oracle.hackson.bean.Employee;
import com.oracle.hackson.bean.EmployeeResult;
import com.oracle.hackson.bean.Organization;

public interface OrganizationService {
	
	public Organization getOrganizationByID(int id);
	
	public List<Organization> getOrganizationBypID(int parent);

}
