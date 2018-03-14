package com.oodles.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.oodles.domain.UserAddress;
import com.oodles.annotations.ContactNumberConstraint;
import com.oodles.annotations.EmailConstraint;
import com.oodles.annotations.PasswordConstraint;
import com.oodles.domain.Role;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String name;
	
	//@NotNull
	@EmailConstraint
	private String email;
	
	@PasswordConstraint
	private String password;
	
	//@NotNull
	@ContactNumberConstraint
	private String phoneNumber;
	
	//private Date dob;
	
	private Boolean isActive = false;
	
	private String gender;
	
	private String confirmationToken;
	
	
	private Boolean EmailVerified=false;

	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_Address_id")
	private UserAddress userAddress;
		
	
	public String getConfirmationToken() {
		return confirmationToken;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}

	
	
	
	
	
	
	public Boolean getEmailVerified() {
		return EmailVerified;
	}

	public void setEmailVerified(Boolean emailVerified) {
		EmailVerified = emailVerified;
	}
	
	
	public UserAddress getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(UserAddress userAddress) {
		this.userAddress = userAddress;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
//	public Date getDob() {
//		return dob;
//	}
//	public void setDob(Date dob) {
//		this.dob = dob;
//	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
