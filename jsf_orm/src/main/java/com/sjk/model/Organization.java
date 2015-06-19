package com.sjk.model;

import com.sjk.model.embedded.Address;
import com.sjk.model.embedded.BaseEntity;
import com.sjk.model.embedded.OrganizationContext;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.hibernate.Session;

@Entity
@Table(name="ORGANIZATION")
public class Organization extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 6081361582451136304L;
	
	@OneToMany(targetEntity=User.class, mappedBy="organization")
	private List<User> users;
	
	private String name;
	private String email;
	private String phone;
    private String street;
	private String postCode;
	private String city;
	private String country;

	@Enumerated(value = EnumType.STRING)
	private OrganizationContext context;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public OrganizationContext getContext() {
		return context;
	}

	public void setContext(OrganizationContext context) {
		this.context = context;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	/*public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}*/

	public Organization() {
		super();
		//address = new Address();

	}

	public Organization(List<User> users, String name, String email,
			String phone, String street, String postCode, String city, String country) {
		super();
		this.users = users;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.street = street;
		this.postCode = postCode;
		this.city = city;
		this.country = country;
		//this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Organization other = (Organization) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Organization [users=" + users + ", name=" + name + ", email="
				+ email + ", phone=" + phone + ", address=" + street + ", " + city + " " + postCode + ", " + country +"]";
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
}
