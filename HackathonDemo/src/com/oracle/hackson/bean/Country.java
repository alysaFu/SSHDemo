package com.oracle.hackson.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Country")
public class Country implements Serializable{

	private static final long serialVersionUID = -3132543219443475872L;
	
	//countryCode is key
	private String countryCode;
	private String countryName;

	@Id
    @GenericGenerator(name = "codeGenerator", strategy = "assigned")  
    @GeneratedValue(generator = "codeGenerator") 
	@Column(name = "CountryCode", length = 4)  
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	@Column(name = "CountryName", length = 30)  
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
}
