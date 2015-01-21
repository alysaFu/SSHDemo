package com.oracle.hackson.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Employee")
public class Employee implements Serializable{

	private static final long serialVersionUID = -2569117263758746857L;
	
	private int employeeID;
	private int orgID;
	private int managerLevel;
	private String firstName;
	private String middleName;
	private String lastName;
	private char gender;
	private int jobTitle;
	private String countryCode;
	private int addressID;
	private int buildingID;
	private int floor;
	private String office;
	private String mobilePhone;
	private String workPhone;
	private String email;
	private String photo;


	@Id
    @GenericGenerator(name = "idGenerator", strategy = "increment")  
    @GeneratedValue(generator = "idGenerator") 
	@Column(name = "EmployeeID", length = 10)  
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	
	@Column(name = "OrgID", length = 8)  
	public int getOrgID() {
		return orgID;
	}
	public void setOrgID(int orgID) {
		this.orgID = orgID;
	}
	
	@Column(name = "ManagerLevel", length = 4)  
	public int getManagerLevel() {
		return managerLevel;
	}
	public void setManagerLevel(int managerLevel) {
		this.managerLevel = managerLevel;
	}
	
	@Column(name = "FirstName", length = 50)  
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "MiddleName", length = 50)  
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	@Column(name = "LastName", length = 50)  
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "Gender", length = 1)  
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	@Column(name = "CountryCode", length = 4)  
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	@Column(name = "JobTitle", length = 4)  
	public int getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(int jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	@Column(name = "AddressID", length = 10)  
	public int getAddressID() {
		return addressID;
	}
	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}
	
	@Column(name = "BuildingID", length = 8)  
	public int getBuildingID() {
		return buildingID;
	}
	public void setBuildingID(int buildingID) {
		this.buildingID = buildingID;
	}
	
	@Column(name = "Floor", length = 8)  
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	
	@Column(name = "Office", length = 8)  
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	
	@Column(name = "MobilePhone", length = 20)  
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	
	@Column(name = "WorkPhone", length = 20)  
	public String getWorkPhone() {
		return workPhone;
	}
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}
	
	@Column(name = "Email", length = 50)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "Photo", length = 50)
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	

}
