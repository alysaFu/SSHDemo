package com.oracle.hackson.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="JobTitle")
public class JobTitle implements Serializable{

	private static final long serialVersionUID = -5293820924062697959L;
	
	//jobID is uniq
	private int jobID;
	private String description;

	@Id
    @GenericGenerator(name = "idGenerator", strategy = "increment")  
    @GeneratedValue(generator = "idGenerator") 
	@Column(name = "JobID", length = 4)  
	public int getJobID() {
		return jobID;
	}
	public void setJobID(int jobID) {
		this.jobID = jobID;
	}
	
	@Column(name = "Desc", length = 100)  
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
