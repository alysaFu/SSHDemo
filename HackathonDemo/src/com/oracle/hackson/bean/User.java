package com.oracle.hackson.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.oracle.hackson.util.EncryptUtil;


@Entity
@Table(name="user")
public class User implements Serializable{

	private static final long serialVersionUID = -344801733954685547L;
	
	//email is uniq
	private String email;
	private String name;
	private String gender;
	private String single;
	private String sexualPrefer;
	private String birthday;
	private String location;
	private String telephone;
	private String company;
	private String department;
	private String title;
	private String photo;
	private String passwd;


	@Id
    @GenericGenerator(name = "idGenerator", strategy = "assigned")  
    @GeneratedValue(generator = "idGenerator") 
	@Column(name = "email", length = 50)  
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "telephone", length = 30)  
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	@Column(name = "gender", length = 2)  
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Column(name = "sexualprefer", length = 2)  
	public String getSexualPrefer() {
		return sexualPrefer;
	}
	public void setSexualPrefer(String sexualPrefer) {
		this.sexualPrefer = sexualPrefer;
	}
	
	@Column(name = "single", length = 2)  
	public String getSingle() {
		return single;
	}
	public void setSingle(String single) {
		this.single = single;
	}
	@Column(name = "birthday", length = 20)  
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	@Column(name = "company", length = 100)  
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	@Column(name = "department", length = 30)  
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Column(name = "title", length = 30)  
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name = "photo", length = 50)  
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	@Column(name = "name", length = 50)  
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "passwd", length = 100)  
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = EncryptUtil.md5Encryption(passwd);
	}
	
	@Column(name = "location", length = 50)  
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

}
