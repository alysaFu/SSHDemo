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

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{

	private BasicDAO<Employee> employeeDAO;

	private BasicDAO<Organization> organizationDAO;
	
	private BasicDAO<ManagerLevel> levelDAO;
	
	private BasicDAO<JobTitle> titleDAO;

	private BasicDAO<Country> countryDAO;
	
	private BasicDAO<Address> addrDAO;
	
	private BasicDAO<Building> buildingDAO;

	@Override
	public Employee getEmployeeByEmail(String email) {
		// TODO Auto-generated method stub
		Employee em = employeeDAO.get(" from Employee em where em.email = ?", 
				new Object[] {email});
		return em;
	}

	@Override
	public EmployeeResult getEmployeeByID(int id) {
		// TODO Auto-generated method stub
		Employee em = employeeDAO.get(" from Employee em where em.employeeID = ?", 
				new Object[] {id});
		return employee2result(em);
	}
	

	@Override
	public List<EmployeeResult> getEmployeeByorgID(int orgID) {
		// TODO Auto-generated method stub
		List<EmployeeResult> rsList = new ArrayList<EmployeeResult>();
		List<Employee> em = null;
	    em = employeeDAO.find(" from Employee em where em.orgID = ?",
					new Object[] {orgID});
	    if(em != null){
			for(int i = 0; i < em.size(); ++i){
				rsList.add(employee2result(em.get(i)));
			}
		}
		return rsList;
	}

	private EmployeeResult employee2result(Employee em) {
		// TODO Auto-generated method stub
		EmployeeResult result = new EmployeeResult();
		result.setEmployeeID(em.getEmployeeID());
		result.setFirstName(em.getFirstName());
		result.setMiddleName(em.getMiddleName());
		result.setLastName(em.getLastName());
		result.setMobilePhone(em.getMobilePhone());
		result.setWorkPhone(em.getWorkPhone());
		result.setEmail(em.getEmail());
		result.setOffice(em.getOffice());
		result.setPhoto(em.getPhoto());
		if(em.getFloor() != 0)
			result.setFloor(em.getFloor()+"");
		if(em.getGender() != ' '){
			result.setGender("Male");
			if(em.getGender() == 'F')
				result.setGender("Female");
		}
		Organization org = organizationDAO.get(" from Organization org where org.orgID = ?",
				new Object[] { em.getOrgID() });
		if (org != null)
			result.setOrg(org.getDescription());
	    
		ManagerLevel level = levelDAO.get(" from ManagerLevel ml where ml.level = ?",
				new Object[] { em.getManagerLevel() });
		if (level != null)
			result.setManagerLevel(level.getDescription());
	    
		JobTitle title = titleDAO.get(" from JobTitle jt where jt.jobID = ?",
				new Object[] { em.getJobTitle() });
		if (title != null)
			result.setJobTitle(title.getDescription());
	    
	    if(em.getCountryCode() != null && !em.getCountryCode().trim().equals("")){
	    	Country c = countryDAO.get(" from Country t where t.countryCode = ?", 
					new Object[] {em.getCountryCode()});
	    	if(c != null)
	    		result.setCountryName(c.getCountryName());
	    }
	    
	    Address addr = addrDAO.get(" from Address a where a.addressID = ?", 
	    		new Object[] {em.getAddressID()});
	    if(addr != null)
	    	result.setAddress(addr.getDescription());

	    Building building = buildingDAO.get(" from Building b where b.buildingID = ?", 
	    		new Object[] {em.getBuildingID()});
	    if(building != null)
	    	result.setBuilding(building.getDescription());
	    
	    
		return result;
	}

	@Override
	public List<Employee> getEmployeeByUserName(String userName) {
		// TODO Auto-generated method stub
//		List<Employee> em = basicDAO.find(" from Employee em where em.email = ?", 
//				new Object[] {userName});
		
		
		return null;
	}

	@Override
	public List<EmployeeResult> getEmployeeByKeywords(String[] keywords) {
		// TODO Auto-generated method stub
		List<EmployeeResult> rsList = new ArrayList<EmployeeResult>();
		List<Employee> em = null;
		if(keywords.length == 1){
			System.out.println("keyword 1");
			em = employeeDAO.find(" from Employee em where em.firstName = ? or em.email = ? or em.middleName = ?" +
					" or em.lastName=?", 
					new Object[] {keywords[0], keywords[0], keywords[0], keywords[0]});
			//Ä£ºýËÑË÷
			if(em == null || em.size() == 0){
				em = employeeDAO.find(" from Employee em where em.email like ? or em.firstName like ?" +
						" or em.middleName like ? or em.lastName like ?", 
						new Object[] {"%"+keywords[0]+"%", "%"+keywords[0]+"%", "%"+keywords[0]+"%", "%"+keywords[0]+"%"});
			}
		}else if(keywords.length == 2){
			em = employeeDAO.find(" from Employee em where (em.firstName = ? and em.lastName = ?) or " +
                    "(em.middleName = ? and em.lastName = ?) or " +
                    "(em.firstName = ? and em.middleName = ?)",
                    new Object[] {keywords[0], keywords[1], keywords[0], keywords[1],keywords[0], keywords[1]});	
			//Ä£ºýËÑË÷
			if(em == null || em.size() == 0){
				em = employeeDAO.find(" from Employee em where (em.firstName like '%?%' and em.lastName like '%?%') or " +
                        "(em.middleName like '%?%' and em.lastName like '%?%') or " +
                        "(em.firstName like '%?%' and em.middleName like '%?%')",
                        new Object[] {"%"+keywords[0]+"%", "%"+keywords[1]+"%", 
						"%"+keywords[0]+"%", "%"+keywords[1]+"%", 
						"%"+keywords[0]+"%", "%"+keywords[1]+"%"});
			}
		}else if(keywords.length == 3){
			em = employeeDAO.find(" from Employee em where em.firstName = ? and em.middleName = ? " +
					"and em.lastName = ?", keywords);
			//Ä£ºýËÑË÷
			if(em == null || em.size() == 0){
				em = employeeDAO.find(" from Employee em where em.firstName like ? and em.middleName like ? and em.lastName like ?",
						new Object[] {"%"+keywords[0]+"%", "%"+keywords[1]+"%", "%"+keywords[2]+"%"});
			}
		}
		//transform
		if(em != null){
			for(int i = 0; i < em.size(); ++i){
				rsList.add(employee2result(em.get(i)));
			}
		}
		return rsList;
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EmployeeResult getEmployeeResult(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Resource
	public void setEmployeeDAO(BasicDAO<Employee> employeeDAO){
		this.employeeDAO = employeeDAO;
	}
	
	public BasicDAO<Employee> getEmployeeDAO(){
		return employeeDAO;
	}
	
	@Resource
	public void setOrganizationDAO(BasicDAO<Organization> organizationDAO){
		this.organizationDAO = organizationDAO;
	}
	
	public BasicDAO<Organization> getOrganizationDAO(){
		return organizationDAO;
	}
	
	@Resource
	public void setLevelDAO(BasicDAO<ManagerLevel> levelDAO){
		this.levelDAO = levelDAO;
	}
	
	public BasicDAO<ManagerLevel> getLevelDAO(){
		return levelDAO;
	}
	
	@Resource
	public void setTitleDAO(BasicDAO<JobTitle> titleDAO){
		this.titleDAO = titleDAO;
	}
	public BasicDAO<JobTitle> getTitleDAO(){
		return titleDAO;
	}
	
	@Resource
	public void setCountryDAO(BasicDAO<Country> countryDAO){
		this.countryDAO = countryDAO;
	}
	public BasicDAO<Country> getCountryDAO(){
		return countryDAO;
	}
	
	@Resource
	public void setAddrDAO(BasicDAO<Address> addrDAO){
		this.addrDAO = addrDAO;
	}
	public BasicDAO<Address> getAddrDAO(){
		return addrDAO;
	}
	
	@Resource
	public void setBuildingDAO(BasicDAO<Building> buildingDAO){
		this.buildingDAO = buildingDAO;
	}
	public BasicDAO<Building> getBuildingDAO(){
		return buildingDAO;
	}



}
