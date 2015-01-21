package com.oracle.hackson.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Building")
public class Building implements Serializable{

	
	private static final long serialVersionUID = 7836223150763950074L;
	
	private int buildingID;
	private String description;
	private int addressID;

	@Id
    @GenericGenerator(name = "idGenerator", strategy = "increment")  
    @GeneratedValue(generator = "idGenerator") 
	@Column(name = "BuildingID", length = 8)  
	public int getBuildingID() {
		return buildingID;
	}
	public void setBuildingID(int buildingID) {
		this.buildingID = buildingID;
	}
	
	@Column(name = "Desc", length = 100)  
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "AdressID", length = 8)  
	public int getAddressID() {
		return addressID;
	}
	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}

}
