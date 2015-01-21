package com.oracle.hackson.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.oracle.hackson.bean.Employee;
import com.oracle.hackson.bean.EmployeeResult;
import com.oracle.hackson.bean.Organization;
import com.oracle.hackson.service.EmployeeService;
import com.oracle.hackson.service.OrganizationService;
import com.oracle.hackson.service.UserService;

@Controller
public class SearchAction extends ActionSupport{

	private static final long serialVersionUID = -6563331962871796956L;
	
	@Resource
	private EmployeeService employeeService;
	
	@Resource
	private OrganizationService organizationService;
	
	private String keywords = "";
	private String message = "";
	private String email = "";
//	private List<EmployeeResult> employeeResults;

	
	
	//login valid
	public String basicSearch() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String[] keywordList = keywords.split(" ");
		if(keywordList.length != 0){
			List<EmployeeResult> rs = employeeService.getEmployeeByKeywords(keywordList);
			if(rs != null && rs.size() != 0){
				message = "";
				request.getSession().setAttribute("employeeResults", rs);
			}else{
				request.getSession().setAttribute("employeeResults", null);
				message = "No Such User!";
			}
		}
		return SUCCESS;
	}

	//login valid
	public String orgSearch() {
		HttpServletRequest request = ServletActionContext.getRequest();
		email = request.getParameter("email");
		System.out.println("------orgsearch-----------");
		List<EmployeeResult> rsList = new ArrayList<EmployeeResult>();
		System.out.println(email);
		Employee em = employeeService.getEmployeeByEmail(email);
		System.out.println("--------------------"+em.getAddressID());
		Organization org =  organizationService.getOrganizationByID(em.getOrgID());
		Organization parentOrg = organizationService.getOrganizationByID(org.getParentOrgID());
		EmployeeResult parent = employeeService.getEmployeeByID(parentOrg.getManager());
		System.out.println("parent--------------------"+parent.getFirstName());
//		String displayName = "";
//  	   if(parent.getFirstName() != null && parent.getFirstName().trim().length() > 0)
//  		   displayName += parent.getFirstName() + " ";
//  	   if(parent.getMiddleName() != null && parent.getMiddleName().trim().length() > 0)
//  		   displayName += parent.getMiddleName() + " ";
//  	   if(parent.getLastName() != null && parent.getLastName().trim().length() > 0)
//  		   displayName += parent.getLastName() + " ";
  	    rsList.add(parent);
  	    List<EmployeeResult> sonList = new ArrayList<EmployeeResult>();
  	    if(em.getManagerLevel() == 6){
  	    	rsList.addAll(employeeService.getEmployeeByorgID(em.getOrgID()));
  	    }else{
  	    	List<Organization> orgList = organizationService.getOrganizationBypID(em.getOrgID());
  	    	for(int i=0; i<orgList.size(); ++i){
  	    		EmployeeResult em2 = employeeService.getEmployeeByID(orgList.get(i).getManager());
  	    		rsList.add(em2);
  	    	}
  	    }
//  	   for(int i=0; i< sonList.size(); ++i){
//  	    	rsList.add(getDisplayName(sonList.get(i).getFirstName(),sonList.get(i).getMiddleName(),
//  	    			sonList.get(i).getLastName()));
//  	  	    rsList.add(sonList.get(i).getJobTitle());
//    	}
  	   if(rsList != null && rsList.size() != 0){
				message = "";
				request.getSession().setAttribute("orgsList", rsList);
	   }else{
				request.getSession().setAttribute("orgsList", null);
	   }
  		return SUCCESS;
	}
		
	private String getDisplayName(String first, String middle, String last){
		   String displayName = "";
	  	   if(first != null && first.trim().length() > 0)
	  		   displayName += first + " ";
	  	   if(middle != null && middle.trim().length() > 0)
	  		   displayName += middle + " ";
	  	   if(last != null && last.trim().length() > 0)
	  		   displayName += last + " ";
	  	   return displayName;
	}
	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	public static void main(String[] args){
		String keywords="  ";
		String[] keywordList = keywords.split(" ");
		System.out.println("first:"+keywordList.length);
	}

//	public List<EmployeeResult> getEmployeeResults() {
//		return employeeResults;
//	}
//
//	public void setEmployeeResults(List<EmployeeResult> employeeResults) {
//		this.employeeResults = new ArrayList<EmployeeResult>(employeeResults);
//	}


}
