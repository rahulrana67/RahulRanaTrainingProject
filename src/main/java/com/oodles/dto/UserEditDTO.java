package com.oodles.dto;


public class UserEditDTO 
{
	public Long id;
	public String name;
	public String email;
	//public Date dob;
	public String phoneNumber;
	public String gender;
	public String place;
	public String city;
	public String state;
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	/*public Date getDob() {
		return dob;
	}*/
	public String getGender() {
		return gender;
	}
	public String getPlace() {
		return place;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

}
