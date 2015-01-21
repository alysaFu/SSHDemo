package com.oracle.hackson.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Organization")
public class Organization implements Serializable{


	private static final long serialVersionUID = 686152569920690459L;
	
	private int orgID;
	private String description;
	private int manager;
	private int parentOrgID;

	@Id
    @GenericGenerator(name = "idGenerator", strategy = "increment")  
    @GeneratedValue(generator = "idGenerator") 
	@Column(name = "OrgID", length = 8)  
	public int getOrgID() {
		return orgID;
	}
	public void setOrgID(int orgID) {
		this.orgID = orgID;
	}
	
	@Column(name = "Desc", length = 200)  
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "ParentOrgID", length = 8)  
	public int getParentOrgID() {
		return parentOrgID;
	}
	public void setParentOrgID(int parentOrgID) {
		this.parentOrgID = parentOrgID;
	}
	
	@Column(name = "Manager", length = 8)  
	public int getManager() {
		return manager;
	}
	public void setManager(int manager) {
		this.manager = manager;
	}


}
