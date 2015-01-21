package com.oracle.hackson.service;

import java.util.List;

import com.oracle.hackson.bean.Employee;
import com.oracle.hackson.bean.EmployeeResult;

public interface EmployeeService {
	
	public Employee getEmployeeByEmail(String email);
	
	public EmployeeResult getEmployeeByID(int id);
	
	public List<Employee> getEmployeeByUserName(String email);
	
	public List<EmployeeResult> getEmployeeByKeywords(String[] keywords);
	
	public EmployeeResult getEmployeeResult(Employee employee);
	
	public void updateEmployee(Employee employee);

	public List<EmployeeResult> getEmployeeByorgID(int orgID);

}
