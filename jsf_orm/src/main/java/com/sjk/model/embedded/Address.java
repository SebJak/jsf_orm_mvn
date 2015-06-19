package com.sjk.model.embedded;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Address implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3156041417213320916L;

	private String street;
	
	private String postCode;
	
	private String city;
	
	private String country;

	public Address(String street, String postCode, String city, String country) {
		super();
		this.street = street;
		this.postCode = postCode;
		this.city = city;
		this.country = country;
	}

	public Address() {
		super();
	}
	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return street + ", " + postCode + " " + city + ", " + country;
	}
	
	
}
