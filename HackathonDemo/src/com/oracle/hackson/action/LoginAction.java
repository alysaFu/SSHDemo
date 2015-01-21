package com.oracle.hackson.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.oracle.hackson.bean.User;
import com.oracle.hackson.service.EmployeeService;
import com.oracle.hackson.service.UserService;
import com.oracle.hackson.util.EncryptUtil;

@Controller
public class LoginAction extends ActionSupport{

	private static final long serialVersionUID = -6563331962871796956L;

	@Resource
	private UserService userService;
	
	private String email="";
	private String name="";
	private String gender="";
	private String single="";
	private String sexualPrefer="";
	private String location="";
	private String birthday="";
	private String telephone="";
	private String company="";
	private String department="";
	private String title="";
	private String passwd="";
	private String message="";
	
	//login valid
	public String login() {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = userService.getUserByEmail(email);
		if(user == null){
			setMessage("This email was not existed!");
		}else{
			User user2 = userService.findUserByEmailAndPassword(email, EncryptUtil.md5Encryption(passwd));
			if(user2 == null){
				setMessage("Email and password were not matched!");
			}else{
				setMessage("Welcome");
				request.getSession().setAttribute("username", user2.getName());
			}
		}
		return SUCCESS;
	}
	
	//for user logout
	public String logout() {
		HttpServletRequest request = ServletActionContext.getRequest();
		setMessage("Logout");
		request.getSession().setAttribute("username", null);
		return SUCCESS;
	}
	
	//for signup email valid
	public String checkEmail() {
		User user = userService.getUserByEmail(email);
		if(user != null){
			setMessage("This email already existed");
		}else{
			setMessage("");
		}
		return SUCCESS;
	}
	
	//user sign up
	public String signup() {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = new User();
		user.setEmail(email);
		user.setName(name);
		user.setPasswd(passwd);
		user.setSingle(single);
		user.setGender(gender);
		//to do: company,department,etc
		String result = SUCCESS;
		try{
			//save user
			userService.addUser(user);
			request.getSession().setAttribute("username", name);
		}catch(Exception e){
			result = ERROR;
		}
		return result;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSingle() {
		return single;
	}

	public void setSingle(String single) {
		this.single = single;
	}

	public String getSexualPrefer() {
		return sexualPrefer;
	}

	public void setSexualPrefer(String sexualPrefer) {
		this.sexualPrefer = sexualPrefer;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
