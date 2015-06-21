package com.sjk.model;

import com.sjk.model.embedded.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="USER")
@NamedQueries({
		@NamedQuery(
				name = "User.findByLogin",
				query = "from User u WHERE u.login = :login"
		)
})
public class User extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3518942414865678952L;

	@Column(length = 32, nullable = false)
	private String login;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false, length = 32)
	private String name;

	@Column(nullable = false, length = 32)
	private String lastName;

	@Column(length = 16)
	private String phoneNumber;
	@Column(length = 32)
	private String accountNumber;

	@Column(length = 64)
	private String street;

	@Column(length = 8)
	private String postCode;

	@Column(length = 32)
	private String city;

	@Column(length = 32)
	private String country;

	@Column(length = 64, nullable = false)
	private String email;
	//private Address address;

	@ManyToOne(targetEntity=Organization.class)
	@JoinColumn(name = "organizationId")
	private Organization organization;
	
	@Enumerated(EnumType.STRING)
	private Role role;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}*/

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [login=" + login + ", password=" + password + ", name="
				+ name + ", lastName=" + lastName + ", phoneNumber="
				+ phoneNumber + ", accountNumber=" + accountNumber
				+ ", address=" + street + ", " + city + " " + postCode + ", " + country + ",organization=" + organization
				+ ", role=" + role + "]";
	}

	public User(String login, String password, String name, String lastName,
			String phoneNumber, String accountNumber, String street, String postCode, String city, String country,
			Organization organization, Role role) {
		super();
		this.login = login;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.accountNumber = accountNumber;
		this.street = street;
		this.postCode = postCode;
		this.city = city;
		this.country = country;
		//this.address = address;
		this.organization = organization;
		this.role = role;
	}

	public User() {
		super();
		//address = new Address();
		organization = new Organization();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((login == null) ? 0 : login.hashCode());
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
		User other = (User) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
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
