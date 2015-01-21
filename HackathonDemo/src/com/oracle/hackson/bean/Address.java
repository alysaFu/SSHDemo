package com.oracle.hackson.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Address")
public class Address implements Serializable{

	private static final long serialVersionUID = -5953626478248519856L;
	
	private int addressID;
	private String description;
	private String countryCode;

	@Id
    @GenericGenerator(name = "idGenerator", strategy = "increment")  
    @GeneratedValue(generator = "idGenerator") 
	@Column(name = "AddressID", length = 8)  
	public int getAddressID() {
		return addressID;
	}
	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}
	
	@Column(name = "Desc", length = 200)  
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Column(name = "CountryCode", length = 4)  
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

}
